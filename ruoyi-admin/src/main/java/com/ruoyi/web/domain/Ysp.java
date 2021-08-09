package com.ruoyi.web.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Ysp {
    private String sbid;
    private String sbmc;
    private Date occur_time;
    private BigDecimal ch4;
    private BigDecimal c2h4;
    private BigDecimal c2h6;
    private BigDecimal c2h2;
    private BigDecimal h2;
    private BigDecimal co;
    private BigDecimal co2;
    private BigDecimal wl;
    private BigDecimal zt;
    private BigDecimal zkr;
    private BigDecimal dqfh;

    public Date getOccur_time() {
        return occur_time;
    }

    public void setOccur_time(Date occur_time) {
        this.occur_time = occur_time;
    }

    public String getSbid() {
        return sbid;
    }

    public void setSbid(String sbid) {
        this.sbid = sbid;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    public BigDecimal getCh4() {
        return ch4;
    }

    public void setCh4(BigDecimal ch4) {
        this.ch4 = ch4;
    }

    public BigDecimal getC2h4() {
        return c2h4;
    }

    public void setC2h4(BigDecimal c2h4) {
        this.c2h4 = c2h4;
    }

    public BigDecimal getC2h6() {
        return c2h6;
    }

    public void setC2h6(BigDecimal c2h6) {
        this.c2h6 = c2h6;
    }

    public BigDecimal getC2h2() {
        return c2h2;
    }

    public void setC2h2(BigDecimal c2h2) {
        this.c2h2 = c2h2;
    }

    public BigDecimal getH2() {
        return h2;
    }

    public void setH2(BigDecimal h2) {
        this.h2 = h2;
    }

    public BigDecimal getCo() {
        return co;
    }

    public void setCo(BigDecimal co) {
        this.co = co;
    }

    public BigDecimal getCo2() {
        return co2;
    }

    public void setCo2(BigDecimal co2) {
        this.co2 = co2;
    }

    public BigDecimal getWl() {
        return wl;
    }

    public void setWl(BigDecimal wl) {
        this.wl = wl;
    }

    public BigDecimal getZt() {
        return zt;
    }

    public void setZt(BigDecimal zt) {
        this.zt = zt;
    }

    public BigDecimal getZkr() {
        return zkr;
    }

    public void setZkr(BigDecimal zkr) {
        this.zkr = zkr;
    }

    public BigDecimal getDqfh() {
        return dqfh;
    }

    public void setDqfh(BigDecimal dqfh) {
        this.dqfh = dqfh;
    }
}
