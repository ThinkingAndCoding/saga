package com.go.saga.coordinator.dao;

import com.go.saga.coordinator.model.TransChain;
import com.go.saga.coordinator.model.TransChainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransChainMapper {
    long countByExample(TransChainExample example);

    int deleteByExample(TransChainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransChain record);

    int insertSelective(TransChain record);

    List<TransChain> selectByExample(TransChainExample example);

    TransChain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransChain record, @Param("example") TransChainExample example);

    int updateByExample(@Param("record") TransChain record, @Param("example") TransChainExample example);

    int updateByPrimaryKeySelective(TransChain record);

    int updateByPrimaryKey(TransChain record);
}