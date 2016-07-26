package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
	  DriverManagerDataSource ds=new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost/test?characterEncoding=utf-8");
	  ds.setUsername("root");
	  ds.setPassword("123456");
	  return ds;
  }
  
  @Bean
  public LocalSessionFactoryBean  sessionFactory(DataSource dataSource) {
	  LocalSessionFactoryBean sfb=new LocalSessionFactoryBean();
	  sfb.setDataSource(dataSource);
	  sfb.setPackagesToScan(new String[] {"com.users.model"});
	  Properties props=new Properties();
	  props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
	  //props.setProperty("connection.useUnicode", "true");
	  //props.setProperty("connection.characterEncoding", "utf-8");
	  sfb.setHibernateProperties(props);
	  return sfb;
  }

}