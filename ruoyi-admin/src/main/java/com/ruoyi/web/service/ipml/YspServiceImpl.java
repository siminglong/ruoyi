package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Ysp;
import com.ruoyi.web.mapper.YspMapper;
import com.ruoyi.web.service.YspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YspServiceImpl implements YspService {
    @Autowired
    private YspMapper yspMapper;
    @Override
    public List selectYsp(String time) {
        return this.yspMapper.selectYsp(time);
    }

    @Override
    public List selectLeast() {
        return this.yspMapper.selectLeast();
    }

    @Override
    public List selectOld() {
        return this.yspMapper.selectOld();
    }

    @Override
    public List selectBySQL() {
        return this.yspMapper.selectBySQL();
    }

    @Override
    public List selectBySQL2() {
        return this.yspMapper.selectBySQL2();
    }

    @Override
    public Ysp selectNewById(String sbid) {
        return this.yspMapper.selectNewById(sbid);
    }

    @Override
    public Ysp selectOldById(String sbid) {
        return this.yspMapper.selectOldById(sbid);
    }

    @Override
    public List<String> selectSbid() {
        return this.yspMapper.selectSbid();
    }

}
