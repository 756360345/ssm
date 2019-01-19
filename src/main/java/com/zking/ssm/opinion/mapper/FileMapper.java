package com.zking.ssm.opinion.mapper;

import com.zking.ssm.opinion.model.File;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
    int insert(File record);

    int insertSelective(File record);
}