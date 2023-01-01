/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.controller;

import com.java.test.junior.dto.ProductDto;
import com.java.test.junior.model.Product;
import com.java.test.junior.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Product createProduct(@RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        product.setId(id);
        productService.updateProductById(product);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}