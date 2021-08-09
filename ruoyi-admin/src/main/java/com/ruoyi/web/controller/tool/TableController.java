package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.Category;
import com.ruoyi.web.domain.Order;
import com.ruoyi.web.domain.Product;
import com.ruoyi.web.service.CategoryService;
import com.ruoyi.web.service.OrderItemService;
import com.ruoyi.web.service.OrderService;
import com.ruoyi.web.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("多表操作")
@RestController
@RequestMapping("/test/duobiao/")
public class TableController extends BaseController {
    //多表关联
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @ApiOperation("查询列表")
    @GetMapping("/sc/list")
    public AjaxResult selectlistcategory(){
        List<Category> categoryList = new ArrayList<>(categoryService.listCategory());
        return AjaxResult.success("查询列表成功",categoryList);
    }

    @ApiOperation("查询category列表")
    @GetMapping("/sc/{id}")
    public AjaxResult selectlistcategory(Integer id){
        List<Category> categoryList = new ArrayList<>(categoryService.listCategory(id));
        if(categoryList!=null){
            return AjaxResult.success("查询列表成功",categoryList);
        }
        else {
            return error("该category不存在");
        }
    }

    @ApiOperation("查询product")
    @GetMapping("/sp/{id}")
    public AjaxResult selectProduct(Integer id){
        Product product = productService.selectProduct(id);
        if (product!=null){
            return AjaxResult.success("查询product成功",product);
        }
        else {
            return error("该product不存在");
        }
    }

    @ApiOperation("查询product列表")
    @GetMapping("/sp/list")
    public AjaxResult listProduct(){
        List<Product> productList = new ArrayList<>(productService.listProduct());
        return AjaxResult.success("查询列表成功",productList);
    }

    @ApiOperation("查询order列表")
    @GetMapping("/so/list")
    public AjaxResult listOrder(){
        List<Order> orderList = new ArrayList<>(orderService.orderlist());
        return AjaxResult.success("查询所有订单成功",orderList);
    }

    @ApiOperation("查询指定order")
    @GetMapping("/so/{id}")
    public AjaxResult getOrder(Integer id){
        Order orderList = orderService.getOrder(id);
        if(orderList!=null){
            return AjaxResult.success("查询指定订单成功",orderList);
        }
        else {
            return error("该order不存在");
        }
    }

    @ApiOperation("更新")
    @PutMapping("/so/update")
    public AjaxResult updateOrder(Order order){
        orderService.updateOrder(order);
        return AjaxResult.success();
    }

    @ApiOperation("新增")
    @PostMapping("/so/insert")
    public AjaxResult insertOrder(String code,Integer pid,Integer number) {
        orderService.insertOrder1(code);
        Order order = orderService.newOrder();
        int oid = order.getId();
        orderService.insertOrder2(oid, pid, number);
        return AjaxResult.success();
    }


    @ApiOperation("查询order列表")
    @GetMapping("/soi/list")
    public AjaxResult listOrderItem(){
        List<Order> orderList = new ArrayList<>(orderItemService.orderItemlist());
        return AjaxResult.success("查询所有订单成功",orderList);
    }

    @ApiOperation("删除整个order")
    @DeleteMapping("/soi/deleteOrder")
    public AjaxResult deleteOrder(Integer id){
        Order orderList = orderService.getOrder(id);
        orderItemService.deleteOrder(id);
        return AjaxResult.success("删除整个order成功",orderList);
    }

    @ApiOperation("删除指定order中指定product")
    @DeleteMapping("/soi/deleteOrderProduct")
    public AjaxResult deleteOrderProduct(Integer oid,Integer pid){
        orderItemService.deleteOrderProduct(oid, pid);
        return AjaxResult.success("删除order中product成功");
    }

    @ApiOperation("更新")
    @PutMapping("/soi/update")
    public AjaxResult update(Integer id,Integer number,String code){
        orderItemService.update(id, number, code);
        return AjaxResult.success();
    }
}
