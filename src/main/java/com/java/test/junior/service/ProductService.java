/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
public interface ProductService {
    /**
     * @param product this product to be created
     */
    Product createProduct(Product product);

    Product findProductById(Long id);

    List<Product> findProductByName(String name);

    void deleteProductById(Long id);

    void updateProductById(Product product);

    Page<Product> findAll(Pageable pageable);
}