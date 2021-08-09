package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.ColumnEnum;
import com.ruoyi.web.service.PzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Api("桥")
@RestController
@RequestMapping("/test/pz/")
public class PzController extends BaseController {

    @Autowired
    private PzService pzService;

    @ApiOperation("按跨径分类统计")
    @GetMapping("/pz/list1")
    public AjaxResult ankjfl(String niand){
        List l = pzService.ankjfl(niand);
        return AjaxResult.success(l);
    }

    @ApiOperation("按结构形式分类统计")
    @GetMapping("/pz/list2")
    public AjaxResult zhuqsbgzjgxs(String niand){
        List l = pzService.zhuqsbgzjgxs(niand);
        return AjaxResult.success(l);
    }

    @ApiOperation("按技术状况分类统计")
    @GetMapping("/pz/list3")
    public AjaxResult jiszkpd(String niand){
        List l = pzService.jiszkpd(niand);
        return AjaxResult.success(l);
    }

    @ApiOperation("按公路类别分类统计")
    @GetMapping("/pz/list4")
    public AjaxResult daolxzdj(String niand){
        List l = pzService.daolxzdj(niand);
        return AjaxResult.success(l);
    }

    @ApiOperation("按危桥数量分类统计")
    @GetMapping("/pz/list5")
    public AjaxResult shifwq(String niand){
        List l = pzService.shifwq(niand);
        return AjaxResult.success(l);
    }

    @ApiOperation("分类统计")
    @GetMapping("/pz/list")
    public AjaxResult type(String niand,String column){
        if (column.equals("ankjf")){
            List l = pzService.ankjfl(niand);
            return AjaxResult.success(l);
        } else if (column.equals("zhuqsbgzjgxs")){
            List l = pzService.zhuqsbgzjgxs(niand);
            return AjaxResult.success(l);
        } else if (column.equals("jiszkpd")){
            List l = pzService.jiszkpd(niand);
            return AjaxResult.success(l);
        } else if (column.equals("daolxzdj")){
            List l = pzService.daolxzdj(niand);
            return AjaxResult.success(l);
        } else if (column.equals("shifwq")){
            List l = pzService.shifwq(niand);
            return AjaxResult.success(l);
        } else {
            return error("类型错误");
        }
    }

    @ApiOperation("分类统计")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "niand", value = "年度"), @ApiImplicitParam(name = "column",value = "分类方式")}
    )
    @GetMapping("/pz/all")
    public AjaxResult all(String niand, ColumnEnum column){
        System.out.println(column.getColumn());
        List l = pzService.all(column.getColumn(), niand);
        return AjaxResult.success(l);
    }
}
