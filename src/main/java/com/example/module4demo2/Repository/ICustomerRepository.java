package com.example.module4demo2.Repository;

import com.example.module4demo2.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query("select c from Customer c where c.cusName = ?1")
    Page<Customer> findOneByCusEmailContaining(Pageable pageable, String cusEmail);


    Page<Customer> findAllByCusNameContaining(Pageable pageable, String cusName);

    List<Customer> cusName(String cusName);
}
