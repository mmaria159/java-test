/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service.impl;

import com.java.test.junior.exception.ProductNotExistsException;
import com.java.test.junior.mapper.ProductLikesMapper;
import com.java.test.junior.mapper.ProductMapper;
import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductLikes;
import com.java.test.junior.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final ProductLikesMapper productLikesMapper;

    @Override
//    @Transactional
    public Product createProduct(Product product) {
        Product savedProduct = productMapper.save(product);
        productLikesMapper.save(new ProductLikes(savedProduct.getId(),savedProduct.getUserId()));
        return savedProduct;
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> existingProduct = productMapper.findProductByName(name);

        if (existingProduct.isEmpty()) {
            throw new ProductNotExistsException("Unknown products with name: " + name);
        }
        return productMapper.findProductByName(name);
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
    public Page<Product> findAll(Pageable pageable) {
        List<Product> content = productMapper.findAll(pageable.getPageNumber(), pageable.getPageSize());
        Long total = productMapper.countAll();
        return new PageImpl<>(content, pageable, total);
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