package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Optional;

import java.util.Map;

public interface OptionalService {
    Map<String,Object> getOptionalList(Integer pageIndex, Integer pageSize);
    Map<String,Object> getOptionalDetailByOptionalId(Integer optionalId);
    void updateOptional(Optional optional);
}
