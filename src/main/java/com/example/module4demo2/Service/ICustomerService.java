package com.example.module4demo2.Service;

import com.example.module4demo2.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {

    Page<Customer> findWithPage(Pageable pageable);

    Page<Customer> findAllByCusName( Pageable pageable, String cusName );

    Page<Customer> findOneByCusEmailContaining(Pageable pageable, String cusEmail);
}
