package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Match;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchMapper {
    List<Match> getMatchListByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    Integer countMatch();
    Match getMatchById(@Param("id")Long id);
}
