package com.br.logistic.domain.services.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteCustomerService {
    private CustomerRepository customerRepository;

    @Transactional
    public void execute(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
