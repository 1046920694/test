package com.zh.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.zh.ssm")
@EnableTransactionManagement
public class AppConfig {
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.user}")
    String user;
    @Value("${jdbc.password}")
    String password;
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
         dataSource.setUrl("jdbc:mysql://localhost:3306/stu?characterEncoding=utf-8&useSSL=false");
         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         dataSource.setUsername("root");
         dataSource.setPassword("root");
         return dataSource;
    }
    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(@Autowired DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver patternResolver=new PathMatchingResourcePatternResolver();
        try {
            sessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:mapper/*.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zh.ssm.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sessionFactoryBean");
        return mapperScannerConfigurer;
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
