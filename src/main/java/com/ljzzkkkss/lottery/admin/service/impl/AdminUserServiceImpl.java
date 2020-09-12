package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.AdminUserMapper;
import com.ljzzkkkss.lottery.admin.model.AdminUser;
import com.ljzzkkkss.lottery.admin.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser findByUserName(String username) {
        return adminUserMapper.findByUserName(username);
    }
}
