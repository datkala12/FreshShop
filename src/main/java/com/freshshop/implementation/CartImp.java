package com.freshshop.implementation;

import com.freshshop.model.Products;
import com.freshshop.repository.ProductRepository;
import com.freshshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@SessionScope
@Controller
public class CartImp implements CartService {

   Map<Integer, Products> cartMap = new HashMap<>();
    @Override
    public Products add(Products product, int qty) {
        if (cartMap.containsKey(product.getProductId())) {
            Products existingProduct = cartMap.get(product.getProductId());
            existingProduct.setQuantity(existingProduct.getQuantity() + qty);
            return existingProduct;
        } else {
            product.setQuantity(qty);
            cartMap.put(product.getProductId(), product);
            return product;
        }
    }


    @Override
    public void remove(int id) {
    	cartMap.remove(id);
    }

    @Override
    public Products update(int id, int qty) {
        if(cartMap.containsKey(id)){
            Products product = cartMap.get(id);
            product.setQuantity(qty);
            return product;
        }
      return null;
    }

    @Override
    public void clear() {
        cartMap.clear();
    }

    @Override
    public Collection<Products> getProducts() {
        return cartMap.values();
    }

    @Override
    public int getCount() {
         return cartMap.values().stream().mapToInt(Products::getQuantity).sum();
    }

    @Override
    public double getAmount() {
        return cartMap.values().stream().mapToDouble(product -> product.getQuantity() * product.getPrice()).sum();
    }

    @Override
    public int getSize() {
        return cartMap.size();
    }
}
