package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class NoteController {
    @Resource
    private NoteService noteService;

    @GetMapping("/note")
    public String note(){
        return "note";
    }

    @ResponseBody
    @GetMapping("/note/list")
    public ReturnBody list(Integer pageIndex, Integer pageSize){
        return new ReturnBody(noteService.getNoteList(pageIndex,pageSize));
    }
}
