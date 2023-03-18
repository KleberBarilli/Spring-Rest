package com.br.logistic.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Customer;
import com.br.logistic.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> findOne(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }
}
