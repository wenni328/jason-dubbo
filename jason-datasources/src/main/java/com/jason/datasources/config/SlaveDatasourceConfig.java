package com.jason.datasources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
 * @author: xieyong
 * @date: 2018/8/31 10:29
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.jason.datasources.mapper.slave" ,sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class SlaveDatasourceConfig {
    /**
     * 配置数据数据源 slave
     * @return
     */
    @Bean(name = "slaveDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    @Primary
    public DataSource slaveDatasource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置session工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "slaveSqlSessionFactory")
//    @Primary
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDatasource") DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:"));
        return bean.getObject();
    }


    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "slaveTransactionManger")
//    @Primary
    public DataSourceTransactionManager slaveTransactionManger(@Qualifier("slaveDatasource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


    /**
     * 模版
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "slaveSqlSessionTemplate")
//    @Primary
    public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
