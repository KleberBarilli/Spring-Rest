package com.br.logistic.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class CustomerController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/customers")
    public List<Customer> findAll(){
      return manager.createQuery("from Customer", Customer.class).getResultList();
    }
}
