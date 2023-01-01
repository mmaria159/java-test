/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.mapper;

import com.java.test.junior.model.Product;
import org.apache.ibatis.annotations.*;

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

//    @Insert("Insert into product(name,price,description,user_id) values (#{name},#{price},#{description},#{userId})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")

    @Select("INSERT INTO product(name, price, description, user_id) " +
            "VALUES (#{name}, #{price}, #{description}, #{userId}) " +
            "RETURNING id, name, price, description, created_at, updated_at, user_id")
    @Options(flushCache = TRUE)
    Product save(Product product);

    @Update("Update product set name=#{name}, price=#{price}, description=#{description}, user_id=#{userId} where id=#{id}")
    void update(Long id);

    @Delete("Delete from product where id=#{id}")
    void deleteProductById(Long id);
}