/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.dto;

import com.java.test.junior.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Getter
@Setter
public class ProductDto {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message ="The price must be greater than 0" )
    private Double price;
    private String description;
    private Long userId;

    public Product toProduct() {
        return new Product(
                name,
                price,
                description,
                userId
        );
    }
}