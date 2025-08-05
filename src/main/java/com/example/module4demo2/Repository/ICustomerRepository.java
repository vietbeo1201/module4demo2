package com.example.module4demo2.Repository;

import com.example.module4demo2.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
