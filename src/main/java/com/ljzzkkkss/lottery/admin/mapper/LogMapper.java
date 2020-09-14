package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<Log> getLogListByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    Integer countLog();
    Integer countLogByContentAndDay(@Param("content")String content,@Param("day")String day);
}
