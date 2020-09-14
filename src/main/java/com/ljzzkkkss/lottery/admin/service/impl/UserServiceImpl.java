package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.UserMapper;
import com.ljzzkkkss.lottery.admin.model.User;
import com.ljzzkkkss.lottery.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String, Object> getUserList(Integer pageIndex, Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<User> dataList = userMapper.getUserListByPage(start,pageSize);
        Integer count = userMapper.countUser();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;

    }
}
