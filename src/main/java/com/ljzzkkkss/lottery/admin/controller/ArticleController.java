package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.Article;
import com.ljzzkkkss.lottery.admin.model.RecommendParam;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import com.ljzzkkkss.lottery.admin.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/article")
    public String article(){
        return "article";
    }

    @ResponseBody
    @GetMapping("/article/list")
    public ReturnBody list(Integer pageIndex,Integer pageSize){
        return new ReturnBody(articleService.getArticleListByPage(pageIndex,pageSize));
    }

    @ResponseBody
    @GetMapping("/article/detail")
    public ReturnBody detail(Integer id){
        return new ReturnBody(articleService.getArticleById(id));
    }

    @ResponseBody
    @PostMapping("/article/insert")
    public ReturnBody insert(Article article){
        article.setHasRecommend(0);
        articleService.insertArticle(article);
        return ReturnType.SUCCESS;
    }

    @ResponseBody
    @PostMapping("/article/update")
    public ReturnBody update(Article article){
        articleService.updateArticleById(article);
        return ReturnType.SUCCESS;
    }

    @ResponseBody
    @PostMapping("/article/delete")
    public ReturnBody delete(Integer id){
        articleService.deleteArticleById(id);
        return ReturnType.SUCCESS;
    }

    @ResponseBody
    @GetMapping("/article/getMatchNotStartList")
    public ReturnBody getMatchNotStartList(Integer articleId){
        return new ReturnBody(articleService.getMatchNotStartList(articleId));
    }

    @ResponseBody
    @PostMapping("/article/insertRecommend")
    public ReturnBody insertRecommend(RecommendParam recommendParam){
        articleService.insertRecommend(recommendParam);
        return ReturnType.SUCCESS;
    }
}
