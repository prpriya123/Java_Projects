package com.mycom.test.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mycom.test.entity.UserEntity;
//@Configuration 
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
/*@ComponentScans(value = { 
	      @ComponentScan("com.mycom.test.dao"),
	      @ComponentScan("com.mycom.test.service") 
	    })*/
public class DBConfig {/*
	
	
	@Autowired
	   private Environment env;
	
	@Bean
	   public DataSource getDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.driver"));
	      dataSource.setUrl(env.getProperty("db.url"));
	      dataSource.setUsername(env.getProperty("db.username"));
	      dataSource.setPassword(env.getProperty("db.password"));
	      return dataSource;
	   }

	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	      factoryBean.setDataSource(getDataSource());
	      
	      Properties props=new Properties();
	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	      props.setProperty(AvailableSettings.DIALECT,
		            "org.hibernate.dialect.MySQLDialect");

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setAnnotatedClasses(UserEntity.class);
	      return factoryBean;
	   }

	   @Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory() {
		final LocalSessionFactoryBuilder obj= new LocalSessionFactoryBuilder(getDataSource());
		obj.setProperty(AvailableSettings.DIALECT,
	            "org.hibernate.dialect.MySQLDialect");
		obj.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
	    obj.setProperty(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, "true");
		   obj.addAnnotatedClasses(UserEntity.class);
		   //.buildSessionFactory();
		return obj.buildSessionFactory();
		
	}
	@Bean
	public DataSource getDataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
	        dataSource.setUsername("root");
	        dataSource.setPassword("password");
	        return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
*/} 