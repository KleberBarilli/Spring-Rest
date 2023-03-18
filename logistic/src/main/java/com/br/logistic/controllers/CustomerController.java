package com.br.logistic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Customer;
import com.br.logistic.domain.repository.CustomerRepository;


@RestController
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> findAll(){
      return customerRepository.findAll();
    }
}
