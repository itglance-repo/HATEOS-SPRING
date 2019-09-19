package com.hateaos.demo.hateaosdemo.Controller;

import com.hateaos.demo.hateaosdemo.domain.Customer;
import com.hateaos.demo.hateaosdemo.dto.CustomerDTO;
import com.hateaos.demo.hateaosdemo.service.CustomerService;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getOne(customerId);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        List<Customer> resource = new ArrayList<>();
        List<Customer> customers = customerService.getAll();
        for(Customer customer: customers){
            addLinks(customer);
            resource.add(customer);
//            resource.add(addLinks(customer));
        }
        return resource;
    }

    @PostMapping
    public Customer insertCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.Insert(customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public Customer deleteCustomer(@PathVariable Long customerId){
        customerService.delete(customerId);
        return null;
    }

    @PutMapping({"/{customerId}"})
    public Customer updateCustomer(@PathVariable Long customerId, CustomerDTO customerDTO){
       return customerService.update(customerId,customerDTO);
    }

    private static Customer addLinks(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(customer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).withSelfRel();
        Link delLink = linkTo(methodOn(CustomerController.class).deleteCustomer(customer.getCustomerId())).withRel("delete");
        Link putLink = linkTo(methodOn(CustomerController.class).updateCustomer(customer.getCustomerId(),customerDTO)).withRel("put");
        customer.add(selfLink);
        customer.add(delLink);
        customer.add(putLink);
        return customer;

    }


}
