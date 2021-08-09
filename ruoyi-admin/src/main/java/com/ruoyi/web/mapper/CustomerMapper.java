package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Customer;

import java.util.List;

public interface CustomerMapper {
    public Customer findCustomer(Integer id);
    public List<Customer> selectCustomerList();
    public int createCustomer(Customer customer);
    public int deleteCustomer (Integer id);
    public int updateCustomer(Customer customer);
}
