/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
public interface ProductService {
    /**
     * @param productDTO this product to be created
     */
    int createProduct(ProductDTO productDTO);

    Product findProductById(Long id);

    void deleteProductById(Long id);

    void updateProductById(Long id);

}