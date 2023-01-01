/*
 * Copyright (c) 2013-2022 Global Database Ltd, All rights reserved.
 */

package com.java.test.junior.mapper;

import com.java.test.junior.model.Product;
import com.java.test.junior.model.ProductDTO;
import org.apache.ibatis.annotations.*;

/**
 * @author dumitru.beselea
 * @version java-test-junior
 * @apiNote 08.12.2022
 */
@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(Long id);

    @Insert("Insert into product(name,price,description,user_id) values (#{name},#{price},#{description},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(ProductDTO productDTO);

    @Update("Update product set name=#{name}, price=#{price}, description=#{description}, user_id=#{userId} where id=#{id}")
    void update(Long id);

    @Delete("Delete from product where id=#{id}")
    void deleteProductById(Long id);
}