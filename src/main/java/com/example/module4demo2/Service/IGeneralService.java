package com.example.module4demo2.Service;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();          //  is a father of all list Type

    void save(E e);

    Optional<E> findById(Long id);  // avoid null variable

    void remove(Long id);
}
