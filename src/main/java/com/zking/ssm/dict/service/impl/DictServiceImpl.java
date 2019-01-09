package com.zking.ssm.dict.service.impl;

import com.zking.ssm.dict.mapper.DictMapper;
import com.zking.ssm.dict.model.Dict;
import com.zking.ssm.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;
    @Override
    public List<Dict> queryDictForType(Dict dict) {
        return dictMapper.queryDictForType(dict);
    }
}
