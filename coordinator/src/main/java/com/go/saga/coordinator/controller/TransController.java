package com.go.saga.coordinator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.go.saga.coordinator.service.TransChainService;
import com.go.saga.coordinator.vo.TransNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * com.go.saga.coordinator.controller
 *
 * @author zhangdong
 * @date 2018/6/7
 */
@RestController
public class TransController {

    @Autowired
    private TransChainService transChainServiceImpl;

    @RequestMapping(value = "transchain", method = RequestMethod.POST)
    public Long load() throws JsonProcessingException {
        List<TransNode> list = new LinkedList();
        list.add(new TransNode("https://ccc.com", "13123"));
        list.add(new TransNode("https://123.com", "333"));
        return transChainServiceImpl.loadTrans(list);
    }

    @RequestMapping(value = "trans", method = RequestMethod.POST)
    public String process() throws JsonProcessingException {
        transChainServiceImpl.execTrans(3L);
        return "OK";
    }
}
