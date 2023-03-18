package com.br.logistic.api.domain.services.customer;

import org.springframework.stereotype.Service;

import com.br.logistic.api.domain.exceptions.DomainException;
import com.br.logistic.api.domain.model.Customer;
import com.br.logistic.api.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindCustomerService {
    private CustomerRepository customerRepository;

    public Customer execute(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new DomainException("Customer not found!"));

    }
}
