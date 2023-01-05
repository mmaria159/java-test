package com.java.test.junior.controller;

import com.java.test.junior.service.ProductLikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductLikesController {
    private final ProductLikesService productLikesService;

    @PutMapping("/{productId}/{userId}/like")
    public void addLikes(@PathVariable Long productId, @PathVariable Long userId) {
        productLikesService.like(productId, userId);
    }

    @PutMapping("/{productId}/{userId}/dislike")
    public void removeLikes(@PathVariable Long productId, @PathVariable Long userId) {
        productLikesService.dislike(productId, userId);
    }
}
