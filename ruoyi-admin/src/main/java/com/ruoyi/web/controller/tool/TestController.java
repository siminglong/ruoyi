package com.ruoyi.web.controller.tool;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.*;
import com.ruoyi.web.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;


/**
 * swagger 用户测试方法
 *
 * @author ruoyi
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController
{
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();
    {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }

    @Autowired
    private  PzService pzService;
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
        }
        if (column.equals("zhuqsbgzjgxs")){
            List l = pzService.zhuqsbgzjgxs(niand);
            return AjaxResult.success(l);
        }
        if (column.equals("jiszkpd")){
            List l = pzService.jiszkpd(niand);
            return AjaxResult.success(l);
        }
        if (column.equals("daolxzdj")){
            List l = pzService.daolxzdj(niand);
            return AjaxResult.success(l);
        }
        if (column.equals("shifwq")){
            List l = pzService.shifwq(niand);
            return AjaxResult.success(l);
        }
        return error("类型错误");
    }

    @ApiOperation("分类统计")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "niand", value = "年度"), @ApiImplicitParam(name = "column",value = "分类方式")}
    )
    @GetMapping("/pz/all")
    public AjaxResult all(String niand,ColumnEnum column){
        List l = pzService.all(column.getColumn(), niand);
        return AjaxResult.success(l);
    }

    //多表关联
    @Autowired
    private CategoryService categoryService;
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

    @Autowired
    private ProductService productService;
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

    @Autowired
    private OrderService orderService;
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

    @Autowired
    private OrderItemService orderItemService;
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


    //单表
    @Autowired
    private CustomerService customerService;
    @ApiOperation("查询customer")
    //@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/customer/{id}")
    public AjaxResult selectCustomer(Integer id){
        Customer customer = customerService.findCustomer(id);
        if (customer!=null){
            return AjaxResult.success("查询customer成功",customer);
        }
        else {
            return error("用户不存在");
        }
    }

    @ApiOperation("查询customer列表")
    @GetMapping("/customer/list")
    public AjaxResult selectAllCustomer(){
        List<Customer> customerList = new ArrayList<>(customerService.selectCustomerList());
        return AjaxResult.success("查询customer列表成功",customerList);
    }

    @ApiOperation("新增customer")
    @PostMapping("/customer/create")
    public AjaxResult createCustomer(Customer customer){
        customerService.createCustomer(customer);
        return AjaxResult.success("新增customer成功",customer);
    }

    @ApiOperation("删除customer")
    @DeleteMapping("/customer/delete")
    public AjaxResult deleteCustomer(Integer id){
        Customer customer = customerService.findCustomer(id);
        if (customer!=null){
            customerService.deleteCustomer(id);
            return AjaxResult.success("删除customer成功",customer);
        }
        else {
            return error("没有该用户");
        }

    }

    @ApiOperation("更新customer")
    @PutMapping("/customer/update")
    public AjaxResult updateCustomer(Customer customer){
        Customer cus = customerService.findCustomer(customer.getId());
        if (cus!=null){
            customerService.updateCustomer(customer);
            return AjaxResult.success("更新customer成功",customer);
        }
        else {
            return error("用户不存在");
        }
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public AjaxResult userList()
    {
        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
        return AjaxResult.success(userList);
    }

    @ApiOperation("获取用户详细")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/{userId}")
    public AjaxResult getUser(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            return AjaxResult.success(users.get(userId));
        }
        else
        {
            return error("用户不存在");
        }
    }

    @ApiOperation("新增用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户id", dataType = "Integer"),
        @ApiImplicitParam(name = "username", value = "用户名称", dataType = "String"),
        @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String"),
        @ApiImplicitParam(name = "mobile", value = "用户手机", dataType = "String")
    })
    @PostMapping("/save")
    public AjaxResult save(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return error("用户ID不能为空");
        }
        return AjaxResult.success(users.put(user.getUserId(), user));
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public AjaxResult update(@RequestBody UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return error("用户ID不能为空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId()))
        {
            return error("用户不存在");
        }
        users.remove(user.getUserId());
        return AjaxResult.success(users.put(user.getUserId(), user));
    }

    @ApiOperation("删除用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/{userId}")
    public AjaxResult delete(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            users.remove(userId);
            return success();
        }
        else
        {
            return error("用户不存在");
        }
    }


}

@ApiModel(value = "UserEntity", description = "用户实体")
class UserEntity
{
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户手机")
    private String mobile;

    public UserEntity()
    {

    }

    public UserEntity(Integer userId, String username, String password, String mobile)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
}
