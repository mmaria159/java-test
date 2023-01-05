package com.java.test.junior.service;

public interface ProductLikesService {
    void like(Long productId, Long userId);

    void dislike(Long productId, Long userId);
}
