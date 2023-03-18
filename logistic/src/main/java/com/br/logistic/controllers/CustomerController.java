package com.br.logistic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Customer;
import com.br.logistic.domain.repository.CustomerRepository;
import com.br.logistic.domain.services.customer.CreateCustomerService;
import com.br.logistic.domain.services.customer.DeleteCustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;
    private CreateCustomerService createCustomerService;
    private DeleteCustomerService deleteCustomerService;

    @GetMapping()
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findOne(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@Valid @RequestBody Customer customer) {
        return createCustomerService.execute(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> update(@Valid @PathVariable Long customerId, @RequestBody Customer customer) {
        if (!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(customerId);
        customer = customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }
        deleteCustomerService.execute(customerId);
        return ResponseEntity.noContent().build();
    }
}
