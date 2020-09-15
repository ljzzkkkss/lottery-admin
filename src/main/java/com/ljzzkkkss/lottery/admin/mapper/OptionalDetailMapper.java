package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.OptionalDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionalDetailMapper {
    List<OptionalDetail> getOptionalDetailByOptionalId(@Param("optionalId")Integer optionalId);
}
