/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.controller;

import com.java.test.junior.dto.ProductDto;
import com.java.test.junior.model.Product;
import com.java.test.junior.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
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
    public Product createProduct(@Valid @RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/by-name")
    public List<Product> findProductByName(@RequestParam("name") String name) {
        return productService.findProductByName(name);
    }

    @GetMapping
    public Page<Product> findAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "30") int size) {
        return productService.findAll(PageRequest.of((page - 1) * size, size, Sort.by(ASC, "id")));
    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
        Product product = productDto.toProduct();
        product.setId(id);
        productService.updateProductById(product);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}