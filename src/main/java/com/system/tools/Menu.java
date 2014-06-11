package com.system.tools;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.common.util.Helper;
import com.system.model.User;

/** 
 * 菜单生成
* @ClassName: Menu 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-9-29 下午02:09:00 
*  
*/

public class Menu {
	Subject currentUser = SecurityUtils.getSubject();
	User user = Helper.getLoginUser();
	String admin="admin";
	/**
	 * 创建顶部菜单
	 * @Title: createTopMenu 
	 * @Description: 
	 * @return  
	 * @author ning.han@baidao.com
	 */
	public String createTopMenu() {
		StringBuffer sb = new StringBuffer();

		if (currentUser.isPermitted("project_manage:nav")||user.getUsername().equals(admin)) {
			sb.append("<li><a href=\"leftmenu?code=project_manage\"><span>项目管理</span></a></li>");
		}
		if (currentUser.isPermitted("integrated_query:nav")||user.getUsername().equals(admin)) {
			sb.append("<li><a href=\"leftmenu?code=integrated_query\"><span>综合查询</span></a></li>");
		}
		if (currentUser.isPermitted("statistical_analysis:nav")||user.getUsername().equals(admin)) {
			sb.append("<li><a href=\"leftmenu?code=statistical_analysis\"><span>统计信息</span></a></li>");
		}
		if (currentUser.isPermitted("system:nav")||user.getUsername().equals(admin)) {
			sb.append("<li><a href=\"leftmenu?code=system\"><span>系统设置</span></a></li>");
		}
		return sb.toString();
	}

	/**
	 * 创建左侧菜单
	 * @Title: createLeftMenu 
	 * @Description: 
	 * @return  
	 * @author ning.han@baidao.com
	 */
	public String createLeftMenu(String code) {

		if (code == null)
			return "";
		StringBuffer sb = new StringBuffer();
		if (code.equals("system:nav")) {
			sb.append("<div class=\"accordion\" fillSpace=\"sideBar\">");
			if (currentUser.isPermitted("system:setting")||user.getUsername().equals(admin)) {//系统设置

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>系统设置</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");

				if (currentUser.isPermitted("system:user:view")||user.getUsername().equals(admin)) {
					sb.append("<li><a id=\"ttt\" href=\"system/user/find\" target=\"navTab\" rel=\"userManagerNav\">用户管理</a></li>");
				}
				if (currentUser.isPermitted("system:role:view")||user.getUsername().equals(admin)) {
					sb.append("<li><a id=\"ttt\" href=\"system/role/find\" target=\"navTab\" rel=\"roleManagerNav\">角色管理</a></li>");
				}
				if (currentUser.isPermitted("system:dic:view")||user.getUsername().equals(admin)) {
					sb.append("<li><a id=\"ttt\" href=\"system/dic/find\" target=\"navTab\" rel=\"dicManagerNav\">数据字典</a></li>");
				}
				if (currentUser.isPermitted("system:unit:view")||user.getUsername().equals(admin)) {
					sb.append("<li><a id=\"ttt\" href=\"system/unit/find\" target=\"navTab\" rel=\"unitManagerNav\">单位管理</a></li>");
				}
				

				sb.append("</ul>");
				sb.append("</div>");
			}
			sb.append("</div>");

		} else if (code.equals("statistical_analysis:nav")) {//统计分析
			sb.append("<div class=\"accordion\" fillSpace=\"sideBar\">");

			//if (currentUser.isPermitted("integrated_query:bridge:menu")||user.getUsername().equals(admin)) {
			sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>道路统计</h2></div>");
			sb.append("<div class=\"accordionContent\">");
			sb.append("<ul class=\"tree treeFolder\">");
			//if (currentUser.isPermitted("integrated_query:bridge:view")) {
			sb.append("<li><a id=\"ttt\" href=\"report/route/summaryReport\" target=\"navTab\" rel=\"routeSummaryReportReportNav\">道路明细汇总报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/route/progressControllReport\" target=\"navTab\" rel=\"routeProgressControllNav\">道路进度控制报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/route/qualityControllReport\" target=\"navTab\" rel=\"routeQualityControllReportNav\">道路质量控制报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/route/totalMileageRoutetypeChart\" target=\"navTab\" rel=\"routeTotalMileageRoutetypeChartNav\">公路里程—行政等级统计图</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/route/totalMileageTechnicalGradeChart\" target=\"navTab\" rel=\"routeTotalMileageTechnicalGradeChartNav\">公路里程—技术等级统计图</a></li>");
			//}
			sb.append("</ul>");
			sb.append("</div>");

			sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>桥梁统计</h2></div>");
			sb.append("<div class=\"accordionContent\">");
			sb.append("<ul class=\"tree treeFolder\">");
			//if (currentUser.isPermitted("integrated_query:bridge:view")) {
			sb.append("<li><a id=\"ttt\" href=\"report/bridge/summaryReport\" target=\"navTab\" rel=\"bridgeSummaryReportReportNav\">桥梁明细汇总报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/bridge/progressControllReport\" target=\"navTab\" rel=\"bridgeProgressControllNav\">桥梁进度控制报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/bridge/qualityControllReport\" target=\"navTab\" rel=\"bridgeQualityControllReportNav\">桥梁质量控制报表</a></li>");
			//}
			sb.append("</ul>");
			sb.append("</div>");

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>养护管理</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				//if (currentUser.isPermitted("integrated_query:bridge:view")) {
			sb.append("<li><a id=\"ttt\" href=\"report/dailyMaintenance/detailReport\" target=\"navTab\" rel=\"dailyMaintenanceReportReportNav\">日常养护报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/minorRepairMaintenance/detailReport\" target=\"navTab\" rel=\"minorRepairMaintenanceReportNav\">小修保养报表</a></li>");
			sb.append("<li><a id=\"ttt\" href=\"report/floodDamage/detailReport\" target=\"navTab\" rel=\"floodDamageReportNav\">小水毁报表</a></li>");
				//}
				sb.append("</ul>");
				sb.append("</div>");

			//}
			sb.append("</div>");
		} else if (code.equals("integrated_query:nav")) {//综合查询
			sb.append("<div class=\"accordion\" fillSpace=\"sideBar\">");
			if (currentUser.isPermitted("integrated_query:route:menu")||user.getUsername().equals(admin)) {

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>道路综合查询</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				if (currentUser.isPermitted("integrated_query:route:view")||user.getUsername().equals(admin)) {
					sb.append("<li><a id=\"ttt\" href=\"search/route/find\" target=\"dialog\" rel=\"searchRouteNav\">道路项目汇总表‎</a></li>");
				}

				sb.append("</ul>");
				sb.append("</div>");
			}
			if (currentUser.isPermitted("integrated_query:bridge:menu")||user.getUsername().equals(admin)) {

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>桥梁综合查询</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				if (currentUser.isPermitted("integrated_query:bridge:view")||user.getUsername().equals(admin)) {
					//sb.append("<li><a id=\"ttt\" href=\"user/find\" target=\"dialog\" rel=\"userManagerNav\">桥梁</a></li>");
				}
				sb.append("</ul>");
				sb.append("</div>");

			}
			sb.append("</div>");
		} else if (code.equals("project_manage:nav")) {//项目管理
			sb.append("<div class=\"accordion\" fillSpace=\"sideBar\">");
			if (currentUser.isPermitted("project_manage:plan:manage")||user.getUsername().equals(admin)) {

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>计划管理</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				if (currentUser.isPermitted("project_manage:plan:route:newpage")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"route/plan/newpage\" target=\"dialog\" width=\"890\" height=\"390\" maxable=false resizable=false rel=\"routePlanSaveNav\">道路项目计划新增</a></li>");
				}
				if (currentUser.isPermitted("project_manage:plan:route:reportpage")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"route/plan/sections/report\" target=\"dialog\" width=\"871\" height=\"485\" maxable=false resizable=false rel=\"routePlanReportManagerNav\">道路项目计划上报</a></li>");
				}
				if (currentUser.isPermitted("project_manage:plan:route:approvalpage")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"route/plan/sections/approval\" target=\"dialog\" width=\"868\" height=\"608\" maxable=false resizable=false rel=\"routePlanApprovalManagerNav\">道路项目计划审核</a></li>");
				}
				if (currentUser.isPermitted("project_manage:plan:bridge:newpage")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"bridge/plan/newpage\" target=\"dialog\" width=\"867\" height=\"495\" maxable=false resizable=false rel=\"bridgePlanSaveNav\">桥梁项目计划新增</a></li>");
				}
				if (currentUser.isPermitted("project_manage:plan:bridge:reportsave")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"bridge/plan/reportsave\" target=\"dialog\" width=\"876\" height=\"532\" maxable=false resizable=false rel=\"bridgePlanReportManagerNav\">桥梁项目计划上报</a></li>");
				}
				if (currentUser.isPermitted("project_manage:plan:bridge:approvalpage")||user.getUsername().equals(admin)) {
					sb.append("<li><a  href=\"bridge/plan/approval\" target=\"dialog\" width=\"876\" height=\"646\" maxable=false resizable=false rel=\"bridgePlanApprovalManagerNav\">桥梁项目计划审核</a></li>");
				}

				sb.append("</ul>");
				sb.append("</div>");
			}
			if (currentUser.isPermitted("project_manage:engineering:manage")||user.getUsername().equals(admin)) {

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>工程管理</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				if(currentUser.isPermitted("project_manage:engineering:route:view")||user.getUsername().equals(admin)){
					sb.append("<li><a href=\"route/engineering/find\" target=\"dialog\" width=\"887\" height=\"585\"  maxable=false resizable=false rel=\"routeEngineeringNav\">道路项目工程管理</a></li>");
				}
				if(currentUser.isPermitted("project_manage:engineering:bridge:view")||user.getUsername().equals(admin)){
					sb.append("<li><a href=\"bridge/engineering/find\" target=\"dialog\" width=\"885\" height=\"598\"  maxable=false resizable=false rel=\"bridgeEngineeringNav\">桥梁项目工程管理</a></li>");
				}
				sb.append("</ul>");
				sb.append("</div>");
			}
			if (currentUser.isPermitted("project_manage:curing")||user.getUsername().equals(admin)) {

				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>养护管理</h2></div>");
				sb.append("<div class=\"accordionContent\">");
				sb.append("<ul class=\"tree treeFolder\">");
				if(currentUser.isPermitted("project_manage:curing:dailymaintenance")||user.getUsername().equals(admin)){
					sb.append("<li><a href=\"route/dailymaintenance/find\" target=\"dialog\" width=\"885\" height=\"598\"  maxable=false resizable=false rel=\"routeDailyMaintenanceNav\" >日常维护</a></li>");
				}
				if(currentUser.isPermitted("project_manage:curing:minorrepair")||user.getUsername().equals(admin)){
					sb.append("<li><a href=\"route/minorRepairMaintenance/find\" target=\"dialog\" width=\"885\" height=\"598\"  maxable=false resizable=false rel=\"routeMinorRepairMaintenanceNav\" >小修保养</a></li>");
				}
				if(currentUser.isPermitted("project_manage:curing:flooddamage")||user.getUsername().equals(admin)){
					sb.append("<li><a href=\"route/floodDamage/find\" target=\"dialog\" width=\"885\" height=\"598\"  maxable=false resizable=false rel=\"floodDamageNav\" >水毁</a></li>");
				}
				sb.append("</ul>");
				sb.append("</div>");

			}
			sb.append("</div>");
		}
		return sb.toString();
	}

}
