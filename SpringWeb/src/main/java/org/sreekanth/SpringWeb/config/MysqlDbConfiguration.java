package org.sreekanth.SpringWeb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class MysqlDbConfiguration {

	@Bean// Object are created for classes (Inbuilt Classes) which are present in to the libraries.
	public LocalSessionFactoryBean getSessionfactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getConnectionProperties());
		sessionFactory.setPackagesToScan("org.sreekanth.SpringWeb.entity");
		return sessionFactory;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sreekanth");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	public static Properties getConnectionProperties() {
		
		Properties properties = new Properties();
		
//		properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
//		properties.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/realm_db");
//		properties.setProperty("hibernate.connection.username","root");
//		properties.setProperty("hibernate.connection.password","password");
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
	}
}
