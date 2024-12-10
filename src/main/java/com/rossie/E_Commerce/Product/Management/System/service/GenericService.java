package com.rossie.E_Commerce.Product.Management.System.service;

import java.util.List;

public interface GenericService<T, ID> {
    List<T> getAll();
    T getById(ID id);
    T getByName(String name);
    T add(Object dto);
    Object deleteById(ID id);
    T updateById(ID id, Object dto);
}