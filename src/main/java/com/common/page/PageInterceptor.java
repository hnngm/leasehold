package com.common.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.common.util.ReflectUtil;

/**
 * 
 * 
 * @description 然后就是实现mybatis提供的拦截器接口，编写我们自己的分页实现，原理就是拦截底层JDBC操作相关的Statement对象，
 *   把前端的分页参数如当前记录索引和每页大小通过拦截器注入到sql语句中 ，即在sql执行之前通过分页参数重新生成分页sql,
 *   而具体的分页sql实现是分离到Dialect接口中去。
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {

	private final static Log log = LogFactory.getLog(PageInterceptor.class);

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		//BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			//return invocation.proceed();
		}
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		//通过反射获取到当前RoutingStatementHandler对象的delegate属性  
		StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
		//获取到当前StatementHandler的 boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了  
		//RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。  
		BoundSql boundSql = delegate.getBoundSql();
		//拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象  
		Object obj = boundSql.getParameterObject();
		Page<?> page = null;
		//这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。  
		if (obj instanceof Page<?>) {
			page = (Page<?>) obj;

			Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
			Dialect.Type databaseType = null;
			try {
				databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
			} catch (Exception e) {
				log.error(e);
			}
			if (databaseType == null) {
				throw new RuntimeException("the value of the dialect property in mybatis-config.xml is not defined : "
						+ configuration.getVariables().getProperty("dialect"));
			}
			Dialect dialect = null;
			switch (databaseType) {
			case MYSQL:
				dialect = new MySqlPage();
				break;
			case MSSQL:
				dialect = new SqlServerPage();
				break;
			case ORACLE:
				dialect = new OraclePage();
				break;
			case POSTGRESQL:
				dialect = new PostgresqlSqlPage();
				break;
			default:
				dialect = new MySqlPage();
			}

			String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
			metaStatementHandler.setValue("delegate.boundSql.sql",
					dialect.getPageSql(originalSql, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize()));
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

			//通过反射获取delegate父类BaseStatementHandler的mappedStatement属性  
			MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
			//拦截到的prepare方法参数是一个Connection对象  
			Connection connection = (Connection) invocation.getArgs()[0];
			//获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句  
			//String sql = boundSql.getSql();  
			this.setTotalRecord(page, mappedStatement, connection, dialect);
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}

	/** 
	 * 给当前的参数对象page设置总记录数 
	 * 
	 * @param page Mapper映射语句对应的参数对象 
	 * @param mappedStatement Mapper映射语句 
	 * @param connection 当前的数据库连接 
	 */
	private void setTotalRecord(Page<?> page, MappedStatement mappedStatement, Connection connection, Dialect dialect) {
		//获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。  
		//delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。  
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		//获取到我们自己写在Mapper映射语句中对应的Sql语句  
		String sql = boundSql.getSql();
		//通过查询Sql语句获取到对应的计算总记录数的sql语句  

		String queryCountSelect = dialect.getCountString(sql);//SQLUtil.getLineSql(sql);
		//StringBuffer sb = new StringBuffer();
		//int formIndex = SQLUtil.getAfterFormInsertPoint(querySelect);
		//sb.append("select count(0) count ");
		//sb.append(querySelect.substring(formIndex, querySelect.length()));

		//String countSql = sb.toString(); //记录统计     
		//通过BoundSql获取对应的参数映射  
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		//利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。  
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), queryCountSelect, parameterMappings,
				page);
		//通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象  
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
		//通过connection建立一个countSql对应的PreparedStatement对象。  
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(queryCountSelect);
			//通过parameterHandler给PreparedStatement对象设置参数  
			parameterHandler.setParameters(pstmt);
			//之后就是执行获取总记录数的Sql语句和获取结果了。  
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				//给当前的参数page对象设置总记录数  
				page.setRowCount(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
