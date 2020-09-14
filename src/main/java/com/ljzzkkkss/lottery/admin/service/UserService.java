package com.ljzzkkkss.lottery.admin.service;

import java.util.Map;

public interface UserService {
    Map<String,Object> getUserList(Integer pageIndex, Integer pageSize);
}
