package com.ljzzkkkss.lottery.admin.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ljzzkkkss.lottery.admin.model.Match;
import com.ljzzkkkss.lottery.admin.model.Odd;
import com.ljzzkkkss.lottery.admin.service.TaskService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Task {
    private static final Logger log = LoggerFactory.getLogger(Task.class);
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private TaskService taskService;

    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(cron = "*/1 * * * * ?")
    public void getOdd(){
        log.info("getOdd start");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatForMinute = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String page = restTemplate.getForEntity("https://trade.m.500.com/lottery_new_v2/jczq/home/ht",String.class).getBody();
        Document html = Jsoup.parse(page);
        Elements scripts = html.getElementsByTag("script");
        for(Element script : scripts){
            if(script.html().contains("__INITIAL_STATE__")) {
                JSONObject json = JSONObject.parseObject(script.html().split(";")[0].replace("window.__INITIAL_STATE__=",""));
                JSONObject matchList = json.getJSONObject("jczq").getJSONObject("play").getJSONObject("init");
                for(String key : matchList.keySet()){
                    try{
                        JSONObject matchJSON = matchList.getJSONObject(key).getJSONObject("mdata");
                        JSONObject oddJSON = matchList.getJSONObject(key).getJSONObject("pdata");
                        JSONObject single = matchJSON.getJSONObject("subactive");
                        Match match = new Match();
                        match.setMainTeam(matchJSON.getString("homesxname"));
                        match.setClientTeam(matchJSON.getString("awaysxname"));
                        match.setRound(matchJSON.getString("matchnum"));
                        match.setEndTime(matchJSON.getString("endtime"));
                        match.setOwnerDate(matchJSON.getString("matchdate"));
                        match.setMatch(matchJSON.getString("simpleleague"));
                        match.setStatus("未开始");
                        List<Odd> oddList = new ArrayList<>();
                        Date updateTime = new Date();
                        JSONObject nspfJSON = oddJSON.getJSONObject("nspf");
                        for(String oddKey : nspfJSON.keySet()){
                            Odd odd = new Odd();
                            odd.setCategory("胜负平");
                            odd.setSingle(Integer.valueOf(single.getString("nspfdg")));
                            odd.setRate(nspfJSON.getString(oddKey));
                            switch(oddKey){
                                case "draw":
                                    odd.setContent("平");
                                    oddList.add(odd);
                                    break;
                                case "win":
                                    odd.setContent("胜");
                                    oddList.add(odd);
                                    break;
                                case "lost":
                                    odd.setContent("负");
                                    oddList.add(odd);
                                    break;
                                case "time":
                                    if(!StringUtils.isEmpty(nspfJSON.getString(oddKey))){
                                        updateTime = formatForMinute.parse(nspfJSON.getString(oddKey));
                                    }
                                    break;
                            }
                        }
                        JSONObject spfJSON = oddJSON.getJSONObject("spf");
                        for(String oddKey : spfJSON.keySet()){
                            Odd odd = new Odd();
                            odd.setCategory("让球 " + matchJSON.getString("rangqiu"));
                            odd.setSingle(Integer.valueOf(single.getString("spfdg")));
                            odd.setRate(spfJSON.getString(oddKey));
                            switch(oddKey){
                                case "draw":
                                    odd.setContent("平");
                                    oddList.add(odd);
                                    break;
                                case "win":
                                    odd.setContent("胜");
                                    oddList.add(odd);
                                    break;
                                case "lost":
                                    odd.setContent("负");
                                    oddList.add(odd);
                                    break;
                                case "time":
                                    if(!StringUtils.isEmpty(spfJSON.getString(oddKey))){
                                        updateTime = formatForMinute.parse(spfJSON.getString(oddKey));
                                    }
                                    break;
                            }
                        }
                        String oddData = restTemplate.getForEntity("https://evs.500.com/esinfo/lotinfo/lot_info?lotid=46&lottype=huntou_more&matchesid=" + key + "&webviewsource=touch&platform=touch",String.class).getBody();
                        oddJSON = JSONObject.parseObject(oddData).getJSONObject("data");
                        JSONObject bfJSON = oddJSON.getJSONObject("bf_pl");
                        for(String oddKey : bfJSON.keySet()){
                            Odd odd = new Odd();
                            odd.setCategory("比分");
                            odd.setSingle(Integer.valueOf(single.getString("bfdg")));
                            odd.setRate(bfJSON.getString(oddKey));
                            switch(oddKey){
                                case "aother":
                                    odd.setContent("胜其他");
                                    oddList.add(odd);
                                    break;
                                case "bother":
                                    odd.setContent("负其他");
                                    oddList.add(odd);
                                    break;
                                case "cother":
                                    odd.setContent("平其他");
                                    oddList.add(odd);
                                    break;
                                case "updateTime":
                                    if(!StringUtils.isEmpty(bfJSON.getString(oddKey))){
                                        updateTime = format.parse(bfJSON.getString(oddKey));
                                    }
                                    break;
                                default:
                                    if(oddKey.startsWith("b") && oddKey.length() == 3){
                                        odd.setContent(oddKey.charAt(2) + ":" + oddKey.charAt(1));
                                        oddList.add(odd);
                                    }else if((oddKey.startsWith("a") || oddKey.startsWith("c")) && oddKey.length() == 3){
                                        odd.setContent(oddKey.charAt(1) + ":" + oddKey.charAt(2));
                                        oddList.add(odd);
                                    }
                                    break;
                            }
                        }
                        JSONObject bqcJSON = oddJSON.getJSONObject("bqc_pl");
                        for(String oddKey : bqcJSON.keySet()){
                            Odd odd = new Odd();
                            odd.setCategory("半全场");
                            odd.setSingle(Integer.valueOf(single.getString("bqdg")));
                            odd.setRate(bqcJSON.getString(oddKey));
                            switch(oddKey) {
                                case "aa":
                                    odd.setContent("胜胜");
                                    oddList.add(odd);
                                    break;
                                case "ab":
                                    odd.setContent("胜负");
                                    oddList.add(odd);
                                    break;
                                case "ac":
                                    odd.setContent("胜平");
                                    oddList.add(odd);
                                    break;
                                case "ba":
                                    odd.setContent("负胜");
                                    oddList.add(odd);
                                    break;
                                case "bb":
                                    odd.setContent("负负");
                                    oddList.add(odd);
                                    break;
                                case "bc":
                                    odd.setContent("负平");
                                    oddList.add(odd);
                                    break;
                                case "ca":
                                    odd.setContent("平胜");
                                    oddList.add(odd);
                                    break;
                                case "cb":
                                    odd.setContent("平负");
                                    oddList.add(odd);
                                    break;
                                case "cc":
                                    odd.setContent("平平");
                                    oddList.add(odd);
                                    break;
                                case "updateTime":
                                    if (!StringUtils.isEmpty(bqcJSON.getString(oddKey))) {
                                        updateTime = format.parse(bqcJSON.getString(oddKey));
                                    }
                                    break;
                            }
                        }
                        JSONObject jqsJSON = oddJSON.getJSONObject("jqs_pl");
                        for(String oddKey : jqsJSON.keySet()){
                            Odd odd = new Odd();
                            odd.setCategory("总进球");
                            odd.setSingle(Integer.valueOf(single.getString("jqdg")));
                            odd.setRate(jqsJSON.getString(oddKey));
                            switch(oddKey) {
                                case "s0":
                                    odd.setContent("0");
                                    oddList.add(odd);
                                    break;
                                case "s1":
                                    odd.setContent("1");
                                    oddList.add(odd);
                                    break;
                                case "s2":
                                    odd.setContent("2");
                                    oddList.add(odd);
                                    break;
                                case "s3":
                                    odd.setContent("3");
                                    oddList.add(odd);
                                    break;
                                case "s4":
                                    odd.setContent("4");
                                    oddList.add(odd);
                                    break;
                                case "s5":
                                    odd.setContent("5");
                                    oddList.add(odd);
                                    break;
                                case "s6":
                                    odd.setContent("6");
                                    oddList.add(odd);
                                    break;
                                case "s7":
                                    odd.setContent("7+");
                                    oddList.add(odd);
                                    break;
                                case "updateTime":
                                    if (!StringUtils.isEmpty(jqsJSON.getString(oddKey))) {
                                        updateTime = format.parse(jqsJSON.getString(oddKey));
                                    }
                                    break;
                            }
                        }
                        if(null == taskService.getMatchByEndDayAndRound(match.getOwnerDate(),match.getRound()) || ( new Date().getTime()) - updateTime.getTime() < 120000){//两分钟内赔率有更新
                            taskService.upsertOddList(match,oddList);
                        }
                    }catch(Exception e){
                        log.error("getOdd::Exception",e);
                    }
                }
            }
        }
        log.info("getOdd end");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
//    @Scheduled(cron = "*/1 * * * * ?")
    public void getMatchScore(){
        log.info("getMatchScore start");
        SimpleDateFormat formatForMonth = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat formatForDay = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        Date date = calendar.getTime();
        String matchData = restTemplate.getForEntity("https://ews.500.com/static/ews/jczq/" + formatForMonth.format(date) + "/" + formatForDay.format(date) + ".json",String.class).getBody();
        JSONArray matchList = JSONObject.parseObject(matchData).getJSONObject("data").getJSONArray("matches");
        for(int i = 0; i < matchList.size(); i++){
            JSONObject matchJSON = matchList.getJSONObject(i);
            Match match = taskService.getMatchByEndDayAndRound(matchJSON.getString("ownerdate"),matchJSON.getString("order"));
            if(null != match){
                match.setStatus(matchJSON.getString("status_desc"));
                if("未开始".equals(matchJSON.getString("status_desc"))){
                    match.setHalfScore(" - ");
                    match.setTotalScore(" - ");
                }else {
                    match.setHalfScore(matchJSON.getString("homehalfscore") + " - " + matchJSON.getString("awayhalfscore"));
                    match.setTotalScore(matchJSON.getString("homescore") + " - " + matchJSON.getString("awayscore"));
                }
                match.setMatchTime(matchJSON.getString("matchtime"));
                taskService.updateMatch(match);
            }
        }
        matchData = restTemplate.getForEntity("https://ews.500.com/static/ews/jczq/" + formatForMonth.format(new Date()) + "/" + formatForDay.format(new Date()) + ".json",String.class).getBody();
        matchList = JSONObject.parseObject(matchData).getJSONObject("data").getJSONArray("matches");
        for(int i = 0; i < matchList.size(); i++){
            JSONObject matchJSON = matchList.getJSONObject(i);
            Match match = taskService.getMatchByEndDayAndRound(matchJSON.getString("ownerdate"),matchJSON.getString("order"));
            if(null != match){
                match.setStatus(matchJSON.getString("status_desc"));
                if("未开始".equals(matchJSON.getString("status_desc"))){
                    match.setHalfScore(" - ");
                    match.setTotalScore(" - ");
                }else {
                    match.setHalfScore(matchJSON.getString("homehalfscore") + " - " + matchJSON.getString("awayhalfscore"));
                    match.setTotalScore(matchJSON.getString("homescore") + " - " + matchJSON.getString("awayscore"));
                }
                match.setMatchTime(matchJSON.getString("matchtime"));
                taskService.updateMatch(match);
            }
        }
        log.info("getMatchScore end");
    }
}
