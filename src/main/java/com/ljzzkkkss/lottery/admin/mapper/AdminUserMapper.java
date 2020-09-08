package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    AdminUser findByUserName(@Param("username") String username);
}
