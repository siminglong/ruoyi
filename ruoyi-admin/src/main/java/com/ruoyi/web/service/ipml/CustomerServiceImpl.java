package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Customer;
import com.ruoyi.web.mapper.CustomerMapper;
import com.ruoyi.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    public Customer findCustomer(Integer id) {
        return this.customerMapper.findCustomer(id);
    }

    @Override
    public List<Customer> selectCustomerList() {
        return this.customerMapper.selectCustomerList();
    }

    @Override
    public int createCustomer(Customer customer) {
        return this.customerMapper.createCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return this.customerMapper.deleteCustomer(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return this.customerMapper.updateCustomer(customer);
    }
}
