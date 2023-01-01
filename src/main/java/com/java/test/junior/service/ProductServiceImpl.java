/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.exception.ProductNotExistsException;
import com.java.test.junior.mapper.ProductMapper;
import com.java.test.junior.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    /**
     * @param productDTO this product to be created
     * @return the product created from the database
     */
    private final ProductMapper productMapper;

    @Override
    public Product createProduct(Product product) {
        return productMapper.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public void updateProductById(Product product) {
        Product existingProduct = productMapper.findById(product.getId());

        if (isNull(existingProduct)) {
            throw new ProductNotExistsException("Unknown product with id: " + product.getId());
        }

        productMapper.update(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product existingProduct = productMapper.findById(id);

        if (isNull(existingProduct)) {
            throw new ProductNotExistsException("Unknown product with id: " + id);
        }

        productMapper.deleteProductById(id);
    }
}