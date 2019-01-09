package com.zking.ssm.opinion.mapper;

import com.zking.ssm.opinion.model.File;

public interface FileMapper {
    int insert(File record);

    int insertSelective(File record);
}