package com.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.controller.BaseController;


/** 
* @ClassName: UserController 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2014-5-19 下午04:58:03 
*  
*/
@Controller
@RequestMapping("/tt/api")
public class UserController extends BaseController {
	@RequestMapping(value = "/api1")
	@ResponseBody
	public Object getApi() {

		String json = "{\"apiVersion\":\"1.0.0\",\"swaggerVersion\":\"1.2\",\"apis\":[{\"path\":\"/pet\",\"description\":\"Operations about pets\"},{\"path\":\"/user\",\"description\":\"Operations about user\"},{\"path\":\"/store\",\"description\":\"Operations about store\"}],\"authorizations\":{\"oauth2\":{\"type\":\"oauth2\",\"scopes\":[{\"scope\":\"write:pets\",\"description\":\"Modify pets in your account\"},{\"scope\":\"read:pets\",\"description\":\"Read your pets\"}],\"grantTypes\":{\"implicit\":{\"loginEndpoint\":{\"url\":\"http://petstore.swagger.wordnik.com/oauth/dialog\"},\"tokenName\":\"access_token\"},\"authorization_code\":{\"tokenRequestEndpoint\":{\"url\":\"http://petstore.swagger.wordnik.com/oauth/requestToken\",\"clientIdName\":\"client_id\",\"clientSecretName\":\"client_secret\"},\"tokenEndpoint\":{\"url\":\"http://petstore.swagger.wordnik.com/oauth/token\",\"tokenName\":\"auth_code\"}}}}},\"info\":{\"title\":\"Swagger Sample App\",\"description\":\"This is a sample server Petstore server.  You can find out more about Swagger \n    at <a href=\"http://swagger.wordnik.com\">http://swagger.wordnik.com</a> or on irc.freenode.net, #swagger.  For this sample,\n    you can use the api key \"special-key\" to test the authorization filters\",\"termsOfServiceUrl\":\"http://helloreverb.com/terms/\",\"contact\":\"apiteam@wordnik.com\",\"license\":\"Apache 2.0\",\"licenseUrl\":\"http://www.apache.org/licenses/LICENSE-2.0.html\"}}";
		return json;
	}

}
