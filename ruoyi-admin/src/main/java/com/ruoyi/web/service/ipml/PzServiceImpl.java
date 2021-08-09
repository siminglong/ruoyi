package com.ruoyi.web.service.ipml;

import com.ruoyi.web.mapper.PzMapper;
import com.ruoyi.web.service.PzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PzServiceImpl implements PzService {
    @Autowired
    private PzMapper pzMapper;

    /* 按跨径分类统计 */
    @Override
    public List ankjfl(String niand) {
        return pzMapper.ankjfl(niand);
    }

    /* 按结构形式分类统计 */
    @Override
    public List zhuqsbgzjgxs(String niand) {
        return pzMapper.zhuqsbgzjgxs(niand);
    }

    /* 按技术状况分类统计 */
    @Override
    public List jiszkpd(String niand) {
        return pzMapper.jiszkpd(niand);
    }

    /* 按公路类别分类统计 */
    @Override
    public List daolxzdj(String niand) {
        return pzMapper.daolxzdj(niand);
    }

    /* 按危桥数量分类统计 */
    @Override
    public List shifwq(String niand) {
        return pzMapper.shifwq(niand);
    }

    @Override
    public List all(String column, String niand) {
        return pzMapper.all(column, niand);
    }
}
