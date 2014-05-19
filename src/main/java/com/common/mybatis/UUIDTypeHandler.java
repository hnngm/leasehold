package com.common.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * ＵＵＩＤ类型处 理器
* @ClassName: UUIDTypeHandler 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2014-3-21 上午10:43:43 
*
 */
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

	@Override
	public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return UUID.fromString(rs.getString(columnName));
	}

	@Override
	public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return UUID.fromString((cs.getString(columnIndex)));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, ((UUID) parameter).toString());
	}

	@Override
	public UUID getNullableResult(ResultSet rs, int arg1) throws SQLException {
		return UUID.fromString(rs.getString(arg1));
	}
}
