package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.Article;
import com.ljzzkkkss.lottery.admin.model.Banner;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BannerController {
    @Resource
    private BannerService bannerService;

    @GetMapping("/banner")
    public String banner(){
        return "banner";
    }


    @ResponseBody
    @GetMapping("/banner/list")
    public ReturnBody list(){
        return new ReturnBody(bannerService.getBannerList());
    }

    @ResponseBody
    @PostMapping("/banner/insert")
    public ReturnBody insert(Banner banner){
        bannerService.insertBanner(banner);
        return ReturnType.SUCCESS;
    }

    @ResponseBody
    @PostMapping("/banner/update")
    public ReturnBody update(Banner banner){
        bannerService.updateBannerById(banner);
        return ReturnType.SUCCESS;
    }


    @ResponseBody
    @PostMapping("/banner/delete")
    public ReturnBody delete(Integer id){
        bannerService.deleteBannerById(id);
        return ReturnType.SUCCESS;
    }
}
