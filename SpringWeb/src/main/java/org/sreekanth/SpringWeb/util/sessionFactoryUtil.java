package org.sreekanth.SpringWeb.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class sessionFactoryUtil {

	private SessionFactory sessionFactory;
	
	public SessionFactory getFactory() {
		return sessionFactory;
		
	}
}

