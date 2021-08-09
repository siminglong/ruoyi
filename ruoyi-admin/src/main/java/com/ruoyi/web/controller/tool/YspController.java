package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.Ysp;
import com.ruoyi.web.service.YspService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api("t_ysp_data")
@RestController
@RequestMapping("/test/ysp/")
public class YspController extends BaseController {
    @Autowired
    private YspService yspService;

    @ApiOperation("统计")
    @GetMapping("/select")
    public AjaxResult selectYsp(String time){
        List l = yspService.selectYsp(time);
        return AjaxResult.success(time,l);
    }

    @ApiOperation("统计最近日期")
    @GetMapping("/selectLeast")
    public AjaxResult selectLeast(){
        List l = yspService.selectLeast();
        System.out.println(l.get(1));
        return AjaxResult.success(l);
    }

    @ApiOperation("统计最近日期的前7天最近日期")
    @GetMapping("/selectOld")
    public AjaxResult selectOld(){
        List l = yspService.selectOld();
        return AjaxResult.success(l);
    }

    @ApiOperation("通过MySQL统计")
    @GetMapping("/selectBySQL")
    public AjaxResult selectBySQL(){
        List l = yspService.selectBySQL();
        return AjaxResult.success(l);
    }

    @ApiOperation("通过MySQL统计2")
    @GetMapping("/selectBySQL2")
    public AjaxResult selectBySQL2(){
        List l = yspService.selectBySQL2();
        return AjaxResult.success(l);
    }

    @ApiOperation("通过java统计")
    @GetMapping("/selectByJava")
    public AjaxResult selectByJava(){
        List<Ysp> l = new ArrayList<>();
        List<String> sbid = yspService.selectSbid();
//        String[] sbid = {"0319","10020","100549","16121","40010001","9aaf3d266ebf5a46016ebfae4926002a","9aaf3d266ebf5a46016ebfb997a10055"};
        for (int i=0;i<sbid.size();i++){
            Ysp l1 = yspService.selectNewById(sbid.get(i));
            Ysp l2 = yspService.selectOldById(sbid.get(i));
            Ysp y = new Ysp();
            if (l2!=null) {
                y.setSbid(l1.getSbid());
                y.setSbmc(l1.getSbmc());
                y.setOccur_time(l1.getOccur_time());
                y.setCh4(l1.getCh4().subtract(l2.getCh4()));
                y.setC2h4(l1.getC2h4().subtract(l2.getC2h4()));
                y.setC2h6(l1.getC2h6().subtract(l2.getC2h6()));
                y.setC2h2(l1.getC2h2().subtract(l2.getC2h2()));
                y.setH2(l1.getH2().subtract(l2.getH2()));
                y.setCo(l1.getCo().subtract(l2.getCo()));
                y.setCo2(l1.getCo2().subtract(l2.getCo2()));
                y.setWl(l1.getWl().subtract(l2.getWl()));
                y.setZt(l1.getZt().subtract(l2.getZt()));
                y.setZkr(l1.getZkr().subtract(l2.getZkr()));
                y.setDqfh(l1.getDqfh().subtract(l2.getDqfh()));
                l.add(y);
            }else {
                l.add(l1);
            }
        }
        return AjaxResult.success(l);
    }
}
