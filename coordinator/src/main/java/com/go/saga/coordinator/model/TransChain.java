package com.go.saga.coordinator.model;

import java.util.Date;

public class TransChain {
    private Long id;

    private String transName;

    private String transJson;

    private Date insertTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName == null ? null : transName.trim();
    }

    public String getTransJson() {
        return transJson;
    }

    public void setTransJson(String transJson) {
        this.transJson = transJson == null ? null : transJson.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}