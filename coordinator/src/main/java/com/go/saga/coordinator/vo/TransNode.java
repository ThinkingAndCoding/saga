package com.go.saga.coordinator.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.go.saga.coordinator.util.JsonUtil;

import java.io.Serializable;

/**
 * com.go.saga.coordinator.vo
 *
 * @author zhangdong
 * @date 2018/6/7
 */
public class TransNode implements Serializable{

    public TransNode(){}

    public TransNode(String url, String param){
        this.url = url;
        this.param = param;
    }

    private String url;

    private String param;

    private String cburl;

    private String cbparam;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getCburl() {
        return cburl;
    }

    public void setCburl(String cburl) {
        this.cburl = cburl;
    }

    public String getCbparam() {
        return cbparam;
    }

    public void setCbparam(String cbparam) {
        this.cbparam = cbparam;
    }

    @Override
    public String toString(){
        try {
            return JsonUtil.toJson(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
