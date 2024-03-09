package com.freshshop.service;

import com.freshshop.model.Products;

import java.util.Collection;

public interface CartService {

    Products add(Products product, int qty);

    void remove(int id);

    Products update(int id, int qty);

    void clear();

    Collection<Products> getProducts();

    int getCount();

    double getAmount();

    int getSize();
}
