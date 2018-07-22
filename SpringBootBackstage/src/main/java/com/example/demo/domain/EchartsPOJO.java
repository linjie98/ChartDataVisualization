package com.example.demo.domain;

/**
 * @Author: linjie
 * @Description: 时间 人流量实体类
 * @Date: 下午 15:55 2018/7/21 0021
 */
public class EchartsPOJO {
    private String datetime;    //时间
    private Integer flow;   //流量
    /**
     *构造方法
     **/
    public EchartsPOJO(String datetime, Integer flow) {
        this.datetime = datetime;
        this.flow = flow;
    }
    public EchartsPOJO(){}

    /**
     *setter and getter
     **/
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    /**
     *toString方法
     **/
    @Override
    public String toString() {
        return "EchartsPOJO{" +
                "datetime='" + datetime + '\'' +
                ", flow=" + flow +
                '}';
    }
}
