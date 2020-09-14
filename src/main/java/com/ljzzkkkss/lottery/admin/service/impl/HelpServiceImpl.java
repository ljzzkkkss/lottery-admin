package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.HelpMapper;
import com.ljzzkkkss.lottery.admin.model.Help;
import com.ljzzkkkss.lottery.admin.service.HelpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HelpServiceImpl implements HelpService {
    @Resource
    private HelpMapper helpMapper;

    @Override
    public List<Help> getHelpList() {
        return helpMapper.getHelpList();
    }

    @Override
    public void insertHelp(Help help) {
        helpMapper.insertHelp(help);
    }

    @Override
    public void updateHelpById(Help help) {
        helpMapper.updateHelpById(help);
    }

    @Override
    public void deleteHelpById(Integer id) {
        helpMapper.deleteHelpById(id);
    }
}
