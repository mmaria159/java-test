package com.java.test.junior.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductLikes {
    private Long id;
    private Boolean likes;
    private Long productId;
    private Long userId;

    public ProductLikes(Long productId, Long userId) {
        this.productId = productId;
        this.userId = userId;
        this.likes = false;
    }

    public ProductLikes(Long productId, Long userId, Boolean likes) {
        this.productId = productId;
        this.userId = userId;
        this.likes = likes;
    }
}
