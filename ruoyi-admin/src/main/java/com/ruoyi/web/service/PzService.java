package com.ruoyi.web.service;

import java.util.List;

public interface PzService {
    /* 按跨径分类统计 */
    public List ankjfl(String niand);
    /* 按结构形式分类统计 */
    public List zhuqsbgzjgxs(String niand);
    /* 按技术状况分类统计 */
    public List jiszkpd(String niand);
    /* 按公路类别分类统计 */
    public List daolxzdj(String niand);
    /* 按危桥数量分类统计 */
    public List shifwq(String niand);

    public List all(String column,String niand);
}
