package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import com.wordnik.swagger.model.ApiInfo;

/**
 * api管理
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController extends ApiDocumentationController {
	public ApiController() {
		setBaseControllerPackage("com.system.controller");
		List<String> controllerPackages = new ArrayList<String>();
		controllerPackages
				.add("com.knappsack.swagger4springweb.controllers.additionalApi");
		//setAdditionalControllerPackages(controllerPackages);
		
		setBaseModelPackage("com.system.model");
		List<String> modelPackages = new ArrayList<String>();
		modelPackages.add("com.knappsack.swagger4springweb.additionalModels");
		//setAdditionalModelPackages(modelPackages);
		
		setApiVersion("v1");

		ApiInfo apiInfo = new ApiInfo("这个是我的api", "这个是我的api",
				"http://localhost:8080/terms", "http://localhost:8080/contact",
				"MIT", "http://opensource.org/licenses/MIT");
		setApiInfo(apiInfo);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String documentation() {
		return "api";
	}
}
