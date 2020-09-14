package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.LogMapper;
import com.ljzzkkkss.lottery.admin.model.Log;
import com.ljzzkkkss.lottery.admin.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper logMapper;
    @Override
    public Map<String, Object> getLogList(Integer pageIndex, Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<Log> dataList = logMapper.getLogListByPage(start,pageSize);
        Integer count = logMapper.countLog();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;
    }

    @Override
    public Integer countLogByContentAndDay(String content, String day) {
        return logMapper.countLogByContentAndDay(content,day);
    }
}
