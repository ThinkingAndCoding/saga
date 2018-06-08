package com.go.saga.coordinator.dao;

import com.go.saga.coordinator.model.ProcessDetail;
import com.go.saga.coordinator.model.ProcessDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessDetailMapper {
    long countByExample(ProcessDetailExample example);

    int deleteByExample(ProcessDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProcessDetail record);

    int insertSelective(ProcessDetail record);

    List<ProcessDetail> selectByExample(ProcessDetailExample example);

    ProcessDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProcessDetail record, @Param("example") ProcessDetailExample example);

    int updateByExample(@Param("record") ProcessDetail record, @Param("example") ProcessDetailExample example);

    int updateByPrimaryKeySelective(ProcessDetail record);

    int updateByPrimaryKey(ProcessDetail record);
}