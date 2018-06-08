package com.go.saga.coordinator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.go.saga.coordinator.vo.TransNode;

import java.util.List;

/**
 * com.go.saga.coordinator.service
 *
 * @author zhangdong
 * @date 2018/6/7
 */
public interface TransChainService {

    /**
     * 加载事物链
     */
    Long loadTrans(List<TransNode> transNodes) throws JsonProcessingException;

    /**
     * 执行事物链
     */
    void execTrans(Long id);
}
