<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include.inc.jsp"%>
<!DOCTYPE>
<html >
<head>
<base  href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>webgis</title>
<link href="${baseurl}/js/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${baseurl}/js/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${baseurl}/js/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link rel="stylesheet" type="text/css" media="screen" href="${baseurl}/js/jgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="${baseurl}/css/template.css" type="text/css"/>
<!--[if IE]>
<link href="${baseurl}/js/dwz/themes/css/ieHack.css" rel="jsheet" type="text/css" />
<![endif]-->
</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<span  style="color: #b9ccda;text-align: center;font-size: 20px;float: left;height: 50px;width: 270px;" >
				    <div style="font-size: 16px;margin-bottom: 5px;margin-top: 5px;">租赁管理系统<b>
				</span>
				<ul class="nav">
					<li style="color: #b9ccda;"><a href="system/user/update/password" target="dialog" mask="true" height="300">修改密码</a></li>
					<li><a href="system/user/logout">退出()</a></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
				<div class="accordion" fillSpace="sideBar">
				<div class="accordionHeader">
					<h2><span>Folder</span>系统设置</h2>
				</div>
				<div class="accordionContent" >
					<ul class="tree treeFolder">
						<li><a href="system/user/find" target="navTab" rel="userManagerNav">用户管理</a></li>
						<li><a href="system/role/find" target="navTab" rel="roleManagerNav">角色管理</a></li>
						<li><a href="system/dic/find" target="navTab" rel="dicManagerNav">数据字典</a></li>
						<li><a href="system/unit/find" target="navTab" rel="unitManagerNav">单位管理</a></li>
					</ul>
				</div>
			</div>
			</div>
			
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab" >
							<li tabid="main" id="selected" class="main" ><a href="javascript:void(0)"><span><span class="home_icon">主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox" >
					
				</div>
			</div>
		</div>



	</div>
	
	<div id="footer">类型</div>


</body>
</html>
<%@ include file="/common/include.script.jsp"%>
<script type="text/javascript">
$(function(){
	DWZ.init("${baseurl}/js/dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNo", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"js/dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
	
});
</script>