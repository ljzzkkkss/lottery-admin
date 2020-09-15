package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.MatchMapper;
import com.ljzzkkkss.lottery.admin.mapper.OptionalDetailMapper;
import com.ljzzkkkss.lottery.admin.mapper.OptionalMapper;
import com.ljzzkkkss.lottery.admin.model.Optional;
import com.ljzzkkkss.lottery.admin.model.OptionalDetail;
import com.ljzzkkkss.lottery.admin.service.OptionalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OptionalServiceImpl implements OptionalService {
    @Resource
    private OptionalMapper optionalMapper;
    @Resource
    private OptionalDetailMapper optionalDetailMapper;
    @Resource
    private MatchMapper matchMapper;


    @Override
    public Map<String, Object> getOptionalList(Integer pageIndex, Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<Optional> dataList = optionalMapper.getOptionalListByPage(start,pageSize);
        Integer count = optionalMapper.countOptional();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;
    }

    @Override
    public Map<String, Object> getOptionalDetailByOptionalId(Integer optionalId) {
        Optional optional = optionalMapper.getOptionalByOptionalId(optionalId);
        Map<String,Object> result = new HashMap<>();
        List<OptionalDetail> optionalDetailList = optionalDetailMapper.getOptionalDetailByOptionalId(optionalId);
        List<Map<String,Object>> matchList = new ArrayList<>();
        Map<Long,Map<String,Object>> matchMap = new HashMap<>();
        for(OptionalDetail optionalDetail : optionalDetailList){
            Long matchId = optionalDetail.getMatchId();
            if(null == matchMap.get(matchId)){
                Map<String,Object> map = new HashMap<>();
                map.put("match",matchMapper.getMatchById(matchId));
                map.put("optionalDetail",new ArrayList<>());
                matchMap.put(matchId,map);
            }
            ((List<OptionalDetail>) matchMap.get(matchId).get("optionalDetail")).add(optionalDetail);
        }
        for(Long key : matchMap.keySet()){
            List<OptionalDetail> optionalDetails = (List<OptionalDetail>) matchMap.get(key).get("optionalDetail");
            Map<String,List<OptionalDetail>> optionalDetailMap = new HashMap<>();
            Map<String,Object> match = new HashMap<>();
            for(OptionalDetail optionalDetail : optionalDetails){
                if(null == optionalDetailMap.get(optionalDetail.getCategory())){
                    optionalDetailMap.put(optionalDetail.getCategory(),new ArrayList<>());
                }
                optionalDetailMap.get(optionalDetail.getCategory()).add(optionalDetail);
            }
            match.put("match",matchMap.get(key).get("match"));
            match.put("optionalDetail",optionalDetailMap);
            matchList.add(match);
        }
        result.put("optional",optional);
        result.put("match",matchList);
        return result;
    }

    @Override
    public void updateOptional(Optional optional) {
        optionalMapper.updateOptionalById(optional);
    }
}
