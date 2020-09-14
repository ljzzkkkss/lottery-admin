package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserListByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    Integer countUser();
}
