package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pz {
    private String ankjf; // 桥梁跨径
    private String zhuqsbgzjgxs; // 结构形式
    private String jiszkpd; // 技术状况
    private String daolxzdj; // 公路类别
    private String shifwq; // 危桥统计
    private Integer num; // 计数

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getZhuqsbgzjgxs() {
        return zhuqsbgzjgxs;
    }

    public void setZhuqsbgzjgxs(String zhuqsbgzjgxs) {
        this.zhuqsbgzjgxs = zhuqsbgzjgxs;
    }

    public String getAnkjf() {
        return ankjf;
    }

    public void setAnkjf(String ankjf) {
        this.ankjf = ankjf;
    }

    public String getJiszkpd() {
        return jiszkpd;
    }

    public void setJiszkpd(String jiszkpd) {
        this.jiszkpd = jiszkpd;
    }

    public String getDaolxzdj() {
        return daolxzdj;
    }

    public void setDaolxzdj(String daolxzdj) {
        this.daolxzdj = daolxzdj;
    }

    public String getShifwq() {
        return shifwq;
    }

    public void setShifwq(String shifwq) {
        this.shifwq = shifwq;
    }
}
