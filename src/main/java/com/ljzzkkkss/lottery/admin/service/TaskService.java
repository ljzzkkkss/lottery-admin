package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Match;
import com.ljzzkkkss.lottery.admin.model.Odd;

import java.util.List;

public interface TaskService {
    Match getMatchBuMatchTimeAndRound(String matchTime,String round);
    void updateMatch(Match match);
    void upsertOddList(Match match, List<Odd> oddList);
}
