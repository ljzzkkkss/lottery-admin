package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LogController {
    @Resource
    private LogService logService;

    @GetMapping("/log")
    public String log(){
        return "log";
    }

    @ResponseBody
    @GetMapping("/log/list")
    public ReturnBody list(Integer pageIndex, Integer pageSize){
        return new ReturnBody(logService.getLogList(pageIndex,pageSize));
    }

    @ResponseBody
    @GetMapping("/log/count")
    public ReturnBody count(String content, String day){
        return new ReturnBody(logService.countLogByContentAndDay(content,day));
    }
}
