package com.ljzzkkkss.lottery.admin.service;

import java.util.Map;

public interface LogService {
    Map<String,Object> getLogList(Integer pageIndex, Integer pageSize);
    Integer countLogByContentAndDay(String content,String day);
}
