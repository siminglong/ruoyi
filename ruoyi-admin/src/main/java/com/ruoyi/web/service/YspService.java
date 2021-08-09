package com.ruoyi.web.service;

import com.ruoyi.web.domain.Ysp;
import java.util.List;

public interface YspService {
    public List selectYsp(String time);

    public List selectLeast();

    public List selectOld();

    public List selectBySQL();

    public List selectBySQL2();

    public Ysp selectNewById(String sbid);

    public Ysp selectOldById(String sbid);

    public List<String> selectSbid();
}
