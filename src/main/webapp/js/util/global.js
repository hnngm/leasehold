/**
 * 存放全局数据
 */
var globalRouteYearList="";//道路年列表
var globalProjectTypeList="";//项目类型
var globalStructureTypeList="";//结构类型
var globalRouteTypeList="";//道路类型
var globalTechnicalGradeList="";//技术等级

var globalBridgeYearList="";//桥梁年列表
var globalBridgeTypeList="";//桥梁类型
var globalUnitList="";//单位列表


//地图
var popupWindow=null;

var gisServerUrl="http://219.146.211.122:9999/map";//"http://localhost:8899/geoserver";//gis　服务器地址
var globalBingZhou="http://219.146.211.122:9999/static";
$(function(){
	$.getJSON("route/plan/year/list",function(data){
		$.each(data,function(){
			globalRouteYearList+='<option value="'+this+'">'+this+'年</option>';
		});
	});
	$.getJSON("bridge/plan/year/list",function(data){
		$.each(data,function(){
			globalBridgeYearList+='<option value="'+this+'">'+this+'年</option>';
		});
	});
	//单位列表
	for(var key in unitList){
		var item=unitList[key];
		globalUnitList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
	//项目类型
	for(var key in projectTypeList){
		var item=projectTypeList[key];
		globalProjectTypeList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
	//道路类型
	for(var key in roadTypeList){
		var item=roadTypeList[key];
		globalRouteTypeList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
	//技术等级
	for(var key in technicalGradeList){
		var item=technicalGradeList[key];
		globalTechnicalGradeList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
	//结构类型
	for(var key in structureTypeList){
		var item=structureTypeList[key];
		globalStructureTypeList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
	//桥梁类型
	for(var key in bridgeTypeList){
		var item=bridgeTypeList[key];
		globalBridgeTypeList+='<option value="'+item.code+'">'+item.name+'</option>';
	}
})