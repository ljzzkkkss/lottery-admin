package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.AdminUser;

public interface AdminUserService {
    AdminUser findByUserName(String usersname);
}
