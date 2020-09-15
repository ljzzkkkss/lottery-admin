package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.Optional;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.OptionalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Controller
public class OptionalController {
    @Resource
    private OptionalService optionalService;

    @GetMapping("/optional")
    private String optional(){
        return "optional";
    }

    @ResponseBody
    @GetMapping("/optional/list")
    public ReturnBody list(Integer pageIndex, Integer pageSize){
        return new ReturnBody(optionalService.getOptionalList(pageIndex,pageSize));
    }

    @ResponseBody
    @GetMapping("/optional/optionalDetail")
    public ReturnBody optionalDetail(Integer optionalId){
        return new ReturnBody(optionalService.getOptionalDetailByOptionalId(optionalId));
    }

    @ResponseBody
    @PostMapping("/optional/update")
    public ReturnBody update(Optional optional){
        if(!StringUtils.isEmpty(optional.getLotteryImg2())){
            optional.setStatus(3);
        }else if(!StringUtils.isEmpty(optional.getLotteryImg())){
            optional.setStatus(2);
        }
        optionalService.updateOptional(optional);
        return ReturnType.SUCCESS;
    }
}
