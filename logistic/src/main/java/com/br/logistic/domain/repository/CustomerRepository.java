package com.br.logistic.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.logistic.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

        List<Customer> findByNameContaining(String name);
}
