package com.ruoyi.web.domain;

public enum ColumnEnum {
    按跨径分类统计("ankjf"),
    按结构形式分类统计("zhuqsbgzjgxs"),
    按技术状况分类统计("jiszkpd"),
    按公路类别分类统计("daolxzdj"),
    按危桥数量分类统计("shifwq");

    private String column;

    ColumnEnum(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
