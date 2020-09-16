package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMapper {
    List<Recommend> getRecommendListByArticleId(@Param("articleId")Integer articleId);
    void insertRecommend(Recommend recommend);
    void deleteRecommendByArticleId(@Param("articleId")Integer articleId);
}
