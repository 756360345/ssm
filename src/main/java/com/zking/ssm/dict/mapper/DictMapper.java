package com.zking.ssm.dict.mapper;

import com.zking.ssm.dict.model.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictMapper {
    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> queryDictForType(Dict dict);
}