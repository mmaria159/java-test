package com.java.test.junior.config;

import com.java.test.junior.mapper.ProductMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Value("${spring.datasource.driver-class-name}")
    public String DRIVER;
    @Value("${spring.datasource.url}")
    public String URL;
    @Value("${spring.datasource.username}")
    public String USERNAME;
    @Value("${spring.datasource.password}")
    public String PASSWORD;

    @Bean
    public SqlSessionFactory buildSqlSessionFactory() {
        DataSource dataSource = new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        configuration.addMapper(ProductMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
