package com.br.logistic.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.logistic.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
        List<Customer> findByNameContaining(String name);

        Optional<Customer> findByEmail(String email);
}
