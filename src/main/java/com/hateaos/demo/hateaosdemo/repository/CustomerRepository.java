package com.hateaos.demo.hateaosdemo.repository;

import com.hateaos.demo.hateaosdemo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
