package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.NoteMapper;
import com.ljzzkkkss.lottery.admin.model.Note;
import com.ljzzkkkss.lottery.admin.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteMapper noteMapper;
    @Override
    public Map<String, Object> getNoteList(Integer pageIndex, Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<Note> dataList = noteMapper.getNoteListByPage(start,pageSize);
        Integer count = noteMapper.countNote();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;
    }
}
