package com.hateaos.demo.hateaosdemo.dto;

import com.hateaos.demo.hateaosdemo.domain.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String companyName;

    public CustomerDTO() {
    }

    public CustomerDTO(Long customerId, String customerName, String companyName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.companyName = companyName;
    }

    public CustomerDTO(Customer customer) {
        this(customer.getCustomerId(),customer.getCustomerName(),customer.getCompanyName());
    }
}
