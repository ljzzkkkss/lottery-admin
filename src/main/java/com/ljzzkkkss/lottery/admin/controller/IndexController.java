package com.ljzzkkkss.lottery.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.AdminUser;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Resource
    private AdminUserService adminUserService;
    @Value("${file.url}")
    private String fileUrl;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public ReturnBody login(HttpServletRequest request, AdminUser adminUser){
        AdminUser user = adminUserService.findByUserName(adminUser.getUsername());
        if(null == user || StringUtils.isEmpty(adminUser.getPassword())){
            return ReturnType.LOGIN_ERROR;
        }
        if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(adminUser.getPassword().getBytes()))){
            return ReturnType.LOGIN_ERROR;
        }
        request.getSession().setAttribute("user",user);
        return new ReturnBody(fileUrl);
    }

    @ResponseBody
    @PostMapping("/logout")
    public ReturnBody logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return ReturnType.SUCCESS;
    }

}
