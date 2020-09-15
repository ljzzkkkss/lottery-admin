package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Optional;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionalMapper {
    Optional getOptionalByOptionalId(@Param("id")Integer id);
    List<Optional> getOptionalListByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    Integer countOptional();
    void updateOptionalById(Optional optional);
}
