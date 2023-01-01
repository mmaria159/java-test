/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.service;

import com.java.test.junior.mapper.ProductMapper;
import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public int createProduct(ProductDTO productDTO) {
        return productMapper.save(productDTO.toProduct());
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        productMapper.deleteProductById(id);
    }

    @Override
    public void updateProductById(Long id) {
        Product product =  productMapper.findById(id);
        productMapper.update(product.getId());
    }

}