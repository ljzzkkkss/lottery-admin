package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Help;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HelpMapper {
    List<Help> getHelpList();
    void insertHelp(Help help);
    void updateHelpById(Help help);
    void deleteHelpById(@Param("id") Integer id);
}
