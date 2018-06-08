package com.go.saga.coordinator.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.go.saga.coordinator.dao.ProcessDetailMapper;
import com.go.saga.coordinator.dao.TransChainMapper;
import com.go.saga.coordinator.model.ProcessDetail;
import com.go.saga.coordinator.model.TransChain;
import com.go.saga.coordinator.service.TransChainService;
import com.go.saga.coordinator.util.JsonUtil;
import com.go.saga.coordinator.vo.TransNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * com.go.saga.coordinator.service
 *
 * @author zhangdong
 * @date 2018/6/7
 */
@Service
public class TransChainServiceImpl implements TransChainService{

    private static final Logger logger = LoggerFactory.getLogger(TransChainServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProcessDetailMapper processDetailMapper;

    @Autowired
    private TransChainMapper transChainMapper;
    /**
     * 加载事物链
     */
    @Override
    public Long loadTrans(List<TransNode> transNodes) throws JsonProcessingException {
        // save
        TransChain transChain = new TransChain();
        transChain.setTransJson(JsonUtil.toJson(transNodes));
        transChain.setInsertTime(new Date());
        transChainMapper.insertSelective(transChain);
        return transChain.getId();
    }

    /**
     * 执行事物链
     */
    @Override
    public void execTrans(Long id){
        TransChain transChain = transChainMapper.selectByPrimaryKey(id);
        List<TransNode> transNodes = JsonUtil.fromJson(transChain.getTransJson(), List.class);

        ListIterator listIterator = transNodes.listIterator();

        while (listIterator.hasNext()){
            Map transNodeMap = (Map) listIterator.next();
            logger.info(transNodeMap.toString());

            if (!recordAndPost(id, transNodeMap)) {
                while (listIterator.hasPrevious()){
                    Boolean cbre = restTemplate.postForObject(transNodeMap.get("cburl").toString(), transNodeMap.get("cbparam").toString(), Boolean.class);
                    logger.info(transNodeMap.toString());
                    if (!cbre) {
                        logger.error("call back error");
                        // retry
                    }
                }
                break;
            }
        }

    }

    @Transactional
    private boolean recordAndPost(Long chainId, Map transNodeMap){
        ProcessDetail processDetail = new ProcessDetail();
        processDetail.setChainId(chainId);
        processDetail.setInsertTime(new Date());
        processDetail.setParam(transNodeMap.get("param").toString());
        processDetail.setUrl(transNodeMap.get("url").toString());
        processDetailMapper.insertSelective(processDetail);
        return restTemplate.postForObject(transNodeMap.get("url").toString(), transNodeMap.get("param").toString(), Boolean.class);
    }
}
