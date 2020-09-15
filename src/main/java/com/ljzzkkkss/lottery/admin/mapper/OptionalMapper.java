package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Optional;
import org.apache.ibatis.annotations.Param;

public interface OptionalMapper {
    Optional getOptionalByOptionalId(@Param("id")Integer id);
}
