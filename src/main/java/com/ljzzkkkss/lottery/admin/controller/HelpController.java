package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.Banner;
import com.ljzzkkkss.lottery.admin.model.Help;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.HelpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelpController {
    @Resource
    private HelpService helpService;

    @GetMapping("/help")
    public String help(){
        return "help";
    }


    @ResponseBody
    @GetMapping("/help/list")
    public ReturnBody list(){
        return new ReturnBody(helpService.getHelpList());
    }

    @ResponseBody
    @PostMapping("/help/insert")
    public ReturnBody insert(Help help){
        helpService.insertHelp(help);
        return ReturnType.SUCCESS;
    }

    @ResponseBody
    @PostMapping("/help/update")
    public ReturnBody update(Help help){
        helpService.updateHelpById(help);
        return ReturnType.SUCCESS;
    }


    @ResponseBody
    @PostMapping("/help/delete")
    public ReturnBody delete(Integer id){
        helpService.deleteHelpById(id);
        return ReturnType.SUCCESS;
    }
}
