package com.ljzzkkkss.lottery.admin.service;

import java.util.Map;

public interface NoteService {
    Map<String,Object> getNoteList(Integer pageIndex, Integer pageSize);
}
