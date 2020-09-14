package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @ResponseBody
    @GetMapping("/user/list")
    public ReturnBody list(Integer pageIndex, Integer pageSize){
        return new ReturnBody(userService.getUserList(pageIndex,pageSize));
    }

}
