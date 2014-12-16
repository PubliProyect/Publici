package com.vimso.padyu.config;

import java.util.Properties;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author vimso
 */
@Configuration
@EnableJpaRepositories(basePackages={"com.vimso.padyu.bussines.dao.repositorios"})
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DatabaseConfig {

    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driver";
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";
    protected static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.ShowSql";
    private static final String PROPERTY_NAME_HIBERNATE_GENERATE_DDL = "hibernate.GenerateDdl";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_PACKAGES_TO_SCAN = "com.vimso.padyu.dominio";
    
    @Inject
    Environment env;

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return tm;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[]{PROPERTY_PACKAGES_TO_SCAN});
        entityManagerFactoryBean.setPersistenceUnitName("UnidadPersistContexto");

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setShowSql(env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL,Boolean.class));
        va.setGenerateDdl(env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_GENERATE_DDL,Boolean.class));

        entityManagerFactoryBean.setJpaVendorAdapter(va);

        Properties ps = new Properties();
//        ps.put("hibernate.dialect", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        ps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        ps.put("hibernate.hbm2ddl.auto", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        entityManagerFactoryBean.setJpaProperties(ps);
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;

    }

}
