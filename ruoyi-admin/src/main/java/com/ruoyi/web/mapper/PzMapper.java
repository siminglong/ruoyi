package com.ruoyi.web.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PzMapper {
    /* 按跨径分类统计 */
    public List ankjfl(String niand);
    /* 结构形式分类统计 */
    public List zhuqsbgzjgxs(String niand);
    /* 按技术状况分类统计 */
    public List jiszkpd(String niand);
    /* 按公路类别分类统计 */
    public List daolxzdj(String niand);
    /* 按危桥数量分类统计 */
    public List shifwq(String niand);

    public List all(@Param("column") String column, @Param("niand") String niand);
}
