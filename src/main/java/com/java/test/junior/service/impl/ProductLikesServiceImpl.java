package com.java.test.junior.service.impl;

import com.java.test.junior.exception.ProductNotExistsException;
import com.java.test.junior.exception.UserNotExistsException;
import com.java.test.junior.mapper.ProductLikesMapper;
import com.java.test.junior.mapper.ProductMapper;
import com.java.test.junior.mapper.UserMapper;
import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductLikes;
import com.java.test.junior.model.User;
import com.java.test.junior.service.ProductLikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductLikesServiceImpl implements ProductLikesService {
    private final ProductLikesMapper productLikesMapper;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    @Override
    public void like(Long productId, Long userId) {
        Product product = productMapper.findById(productId);
        if (product == null) throw new ProductNotExistsException("Unknown product with id: " + productId);

        User user = userMapper.findById(userId);
        if (user == null) throw new UserNotExistsException("Unknown user with id: " + userId);

        productLikesMapper.update(new ProductLikes(productId, userId, true));
    }

    @Override
    public void dislike(Long productId, Long userId) {
        Product product = productMapper.findById(productId);
        if (product == null) throw new ProductNotExistsException("Unknown product with id: " + productId);

        User user = userMapper.findById(userId);
        if (user == null) throw new UserNotExistsException("Unknown user with id: " + userId);

        productLikesMapper.update(new ProductLikes(productId, userId, false));
    }
}
