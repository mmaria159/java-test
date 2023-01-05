package com.java.test.junior.mapper;

import com.java.test.junior.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import static org.apache.ibatis.annotations.Options.FlushCachePolicy.TRUE;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM postgres.public.user WHERE id = #{id}")
    User findById(Long id);

    @Select("SELECT * FROM postgres.public.user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("INSERT INTO postgres.public.user (username, email, password) " +
            "VALUES (#{username}, #{email}, #{password}) " +
            "RETURNING id, username, email, password")
    @Options(flushCache = TRUE)
    User save(User user);
}
