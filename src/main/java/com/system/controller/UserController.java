package com.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.model.User;


/** 
* @ClassName: UserController 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2014-5-19 下午04:58:03 
*  
*/
@RestController
@RequestMapping(value = "/api/v1/users", produces = {"application/json", "application/xml"})
public class UserController {

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id) {
        User user = new User();
        user.setUsername("fdasfas");
        user.setPassword("fdasfasfasfasfas");
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }
}
