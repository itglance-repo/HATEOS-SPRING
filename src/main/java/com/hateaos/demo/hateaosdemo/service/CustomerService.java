package com.hateaos.demo.hateaosdemo.service;

import com.hateaos.demo.hateaosdemo.domain.Customer;
import com.hateaos.demo.hateaosdemo.dto.CustomerDTO;
import com.hateaos.demo.hateaosdemo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer Insert(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCompanyName(customerDTO.getCompanyName());
        customer.setCustomerName(customerDTO.getCustomerName());
        return customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.delete(id);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getOne(Long id){
        return customerRepository.findOne(id);
    }

    public Customer update(Long id, CustomerDTO customerDTO){
        Customer customer = customerRepository.findOne(id);
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCompanyName(customerDTO.getCompanyName());
        return customerRepository.save(customer);
    }

}
