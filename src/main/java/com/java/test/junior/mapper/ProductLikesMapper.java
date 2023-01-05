package com.java.test.junior.mapper;

import com.java.test.junior.model.ProductLikes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductLikesMapper {
    @Insert("INSERT INTO product_likes(likes, product_id, user_id) values(#{likes}, #{productId}, #{userId})")
    void save(ProductLikes productLikes);

    @Update("UPDATE product_likes SET likes = #{likes} WHERE product_id = #{productId} AND user_id = #{userId}")
    void update(ProductLikes productLikes);
}
