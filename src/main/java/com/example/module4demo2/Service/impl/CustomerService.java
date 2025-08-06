package com.example.module4demo2.Service.impl;

import com.example.module4demo2.Model.Customer;
import com.example.module4demo2.Repository.ICustomerRepository;
import com.example.module4demo2.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findWithPage(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCusName(Pageable pageable, String cusName) {
        return iCustomerRepository.findAllByCusNameContaining(pageable, cusName);
    }

    @Override
    public Page<Customer> findOneByCusEmailContaining(Pageable pageable, String cusEmail) throws Exception {
        Page<Customer> customerOptional =  iCustomerRepository.findOneByCusEmailContaining(pageable, cusEmail);
        if (customerOptional.isEmpty()) {
            throw new Exception("email error");
        }
        return customerOptional;
    }
}
