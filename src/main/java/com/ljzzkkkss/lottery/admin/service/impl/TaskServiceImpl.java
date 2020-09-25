package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.MatchMapper;
import com.ljzzkkkss.lottery.admin.mapper.OddMapper;
import com.ljzzkkkss.lottery.admin.model.Match;
import com.ljzzkkkss.lottery.admin.model.Odd;
import com.ljzzkkkss.lottery.admin.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private MatchMapper matchMapper;
    @Resource
    private OddMapper oddMapper;

    @Override
    public Match getMatchBuMatchTimeAndRound(String matchTime, String round) {
        return matchMapper.getMatchByMatchTimeAndRound(matchTime,round);
    }

    @Override
    public void updateMatch(Match match) {
        matchMapper.updateMatch(match);
    }

    @Override
    @Transactional
    public void upsertOddList(Match match, List<Odd> oddList) {
        Match existsMatch =  matchMapper.getMatchByMatchTimeAndRound(match.getMatchTime(),match.getRound());
        if(null == existsMatch) {
            matchMapper.insertMatch(match);
        }else {
            match.setId(existsMatch.getId());
        }
        if(!oddList.isEmpty()){
            oddMapper.deleteOddByMatchId(match.getId());
            for(Odd odd : oddList){
                odd.setMatchId(match.getId());
                oddMapper.insertOdd(odd);
            }
        }
    }
}
