package com.system.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.controller.BaseController;
import com.system.tools.Menu;

/**
 * 首页
 * @author Administrator
 *
 */
@Controller
public class IndexController extends BaseController {
	Logger logger = Logger.getLogger(IndexController.class);
	private Menu menu = null;
	/**
	 * 首页地址
	 * @return
	 */
	@RequestMapping(value = { "/", "admin" })
	public String index(Model model) {
		//menu = new Menu();
		//model.addAttribute("topmenu", menu.createTopMenu());
		return "admin";
	}

	/**
	 * 获得左侧菜单
	 * @Title: leftMenu 
	 * @Description: 
	 * @return  
	 * @author ning.han@baidao.com
	 */
	@RequestMapping(value = "/leftmenu")
	public String leftMenu(String code) {
		return "system/menus/" + code + "_menu";
	}
}
