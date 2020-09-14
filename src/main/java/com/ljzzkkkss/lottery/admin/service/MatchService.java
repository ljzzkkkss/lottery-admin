package com.ljzzkkkss.lottery.admin.service;

import java.util.Map;

public interface MatchService {
    Map<String,Object> getMatchList(Integer pageIndex,Integer pageSize);
}
