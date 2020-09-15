package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Odd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OddMapper {
    List<Odd> getOddListByMatchId(@Param("matchId")Long matchId);
}
