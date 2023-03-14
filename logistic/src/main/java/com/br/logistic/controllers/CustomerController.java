package com.br.logistic.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Customer;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public List<Customer> findAll(){
        Customer customer = new Customer();

        customer.setId(1L);
        customer.setName("Kleber");
        customer.setEmail("Kb@gmail.com");
        customer.setWhatsapp("54499995999");
        
        return Arrays.asList(customer);
    }
}
