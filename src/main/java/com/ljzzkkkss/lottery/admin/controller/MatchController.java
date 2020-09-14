package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MatchController {
    @Resource
    private MatchService matchService;

    @GetMapping("/match")
    public String article(){
        return "match";
    }

    @ResponseBody
    @GetMapping("/match/list")
    public ReturnBody list(Integer pageIndex, Integer pageSize){
        return new ReturnBody(matchService.getMatchList(pageIndex,pageSize));
    }

}
