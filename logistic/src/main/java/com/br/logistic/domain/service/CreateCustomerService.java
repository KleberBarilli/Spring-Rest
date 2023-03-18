package com.br.logistic.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.exceptions.DomainException;
import com.br.logistic.domain.model.Customer;
import com.br.logistic.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCustomerService {
    private CustomerRepository customerRepository;

    @Transactional
    public Customer execute(Customer customer) {
        boolean isEmailExists = customerRepository.findByEmail(customer.getEmail())
                .stream()
                .anyMatch(customerExist -> !customerExist.equals(customer));

        if (isEmailExists) {
            throw new DomainException("Email already exists!");
        }
        return customerRepository.save(customer);
    }
}
