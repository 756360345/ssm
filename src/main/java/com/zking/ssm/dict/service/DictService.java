package com.zking.ssm.dict.service;

import com.zking.ssm.dict.model.Dict;

import java.util.List;

public interface DictService {

    List<Dict> queryDictForType(Dict dict);
}