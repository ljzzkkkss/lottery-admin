package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {
    List<Note> getNoteListByPage(@Param("start") Integer start,@Param("pageSize")Integer pageSize);
    Integer countNote();
}
