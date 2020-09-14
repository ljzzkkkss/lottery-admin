package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.MatchMapper;
import com.ljzzkkkss.lottery.admin.model.Article;
import com.ljzzkkkss.lottery.admin.model.Match;
import com.ljzzkkkss.lottery.admin.service.MatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatchServiceImpl implements MatchService {
    @Resource
    private MatchMapper matchMapper;

    @Override
    public Map<String, Object> getMatchList(Integer pageIndex,Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<Match> dataList = matchMapper.getMatchListByPage(start,pageSize);
        Integer count = matchMapper.countMatch();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;
    }
}
