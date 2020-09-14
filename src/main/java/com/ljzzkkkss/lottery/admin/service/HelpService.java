package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Help;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HelpService {
    List<Help> getHelpList();
    void insertHelp(Help help);
    void updateHelpById(Help help);
    void deleteHelpById(Integer id);
}
