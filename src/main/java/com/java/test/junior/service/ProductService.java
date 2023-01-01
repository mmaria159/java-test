/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
public interface ProductService {
    /**
     * @param Product this product to be created
     */
    Product createProduct(Product product);

    Product findProductById(Long id);

    void deleteProductById(Long id);

    void updateProductById(Product product);
}