package com.system.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.util.Message;
import com.system.model.User;
import com.wordnik.swagger.annotations.ApiParam;


/** 
* @ClassName: UserController 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2014-5-19 下午04:58:03 
*  
*/
@RestController
@RequestMapping(value = "/user", produces = {"application/json", "application/xml"})
public class UserController {

	/**
	 * 保存用户
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Message save(@RequestBody User user){
		Message message=new Message();
		message.setSuccess(true);
		return message;
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public ResponseEntity<User> findUserById(@PathVariable long id) {
        User user = new User();
        user.setUsername("fdasfas");
        user.setPassword("fdasfasfasfasfas");
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }
}
