/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.mapper;

import com.java.test.junior.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.annotations.Options.FlushCachePolicy.TRUE;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(Long id);

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<Product> findProductByName(@Param("name") String name);

    @Select("INSERT INTO product(name, price, description, user_id) " +
            "VALUES (#{name}, #{price}, #{description}, #{userId}) " +
            "RETURNING id, name, price, description, created_at, updated_at, user_id")
    @Options(flushCache = TRUE)
    Product save(Product product);

    @Update("UPDATE product SET name = #{name}, price = #{price}, " +
            "description = #{description}, user_id = #{userId} " +
            "WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM product WHERE id = #{id}")
    void deleteProductById(Long id);

    @Select("SELECT * FROM product OFFSET #{offset} LIMIT #{size}")
    List<Product> findAll(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT COUNT(*) FROM product")
    Long countAll();
}