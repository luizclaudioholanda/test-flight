package com.testeatech.spring.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.testeatech", entityManagerFactoryRef = "mysqlEngEntityManager", transactionManagerRef = "mysqlEngTransactionManager")
public class PersistenceDBConfiguration {

	@Bean(name = "mysqlEngDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mysqlEngDataSource() {
        return DataSourceBuilder.create().build();
    }

    @PersistenceContext(unitName = "mysqlEng")
    @Bean(name = "mysqlEngEntityManager")
    public LocalContainerEntityManagerFactoryBean oracleEngEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource( mysqlEngDataSource())
                .persistenceUnit("mysqlEng")
                .properties(jpaProperties())
                .packages("com.testeatech")
                .build();
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.DefaultNamingStrategy");
        props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        props.put("hibernate.id.new_generator_mappings", "false");
        //props.put("hibernate.hbm2ddl.auto", "create");
        return props;
    }

    @Bean
    public PlatformTransactionManager mysqlEngTransactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
}
