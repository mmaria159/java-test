package com.java.test.junior.config;

import com.java.test.junior.mapper.ProductMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;
    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USERNAME;
    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Bean
    public DataSource dataSource() {
        return new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
    }

    @Bean
    public Configuration configuration() {
        Environment environment = new Environment("Development", new SpringManagedTransactionFactory(), dataSource());

        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);

        configuration.addMapper(ProductMapper.class);

        return configuration;
    }

    @Bean
    public SqlSessionFactory buildSqlSessionFactory() {
        return new SqlSessionFactoryBuilder().build(configuration());
    }
}
