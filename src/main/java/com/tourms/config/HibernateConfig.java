package com.tourms.config;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
/**
 * Created by aruntvm4u on 2/10/2016.
 */

@Configuration
@EnableTransactionManagement
//@ComponentScan({"com.tourms.config"})
@PropertySource(value = "classpath:application.properties")
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"com.tourms.*.vo"});
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
            dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
            dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
            dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
            dataSource.setMinPoolSize(10);
            dataSource.setMaxPoolSize(100);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxStatementsPerConnection(0);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        props.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        props.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        props.put("hibernate.Ddl.Mode", environment.getRequiredProperty("hibernate.Ddl.Mode"));
        return props;
    }

}
