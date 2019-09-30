package com.jd.gamll.demo.controller;


import com.jd.gamll.demo.bean.UserInfo;
import com.jd.gamll.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("fin")
    public List<UserInfo> findAll(){
        return userService.findAll();
    };
}
