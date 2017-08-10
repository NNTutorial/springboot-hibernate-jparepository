package com.nishant.springboot.hibernate.init;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabseConfiguration {
	
	@Bean
	public DataSource getDS() {
		DriverManagerDataSource dmdatasource=new DriverManagerDataSource();
		dmdatasource.setDriverClassName("org.postgresql.Driver");
		dmdatasource.setUrl("jdbc:postgresql://127.0.0.1:5433/testdb");
		dmdatasource.setUsername("postgres");
		dmdatasource.setPassword("root");
		return dmdatasource;
	}
	
	protected Properties hibconfig() {
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.use_sql_comments", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "false");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.generate_statistics", "false");
		hibernateProperties.setProperty("javax.persistence.validation.mode", "none");
		hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", "true");
		hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", "true");
		hibernateProperties.setProperty("hibernate.current_session_context_class", SpringSessionContext.class.getName());

		return hibernateProperties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean ls=new LocalContainerEntityManagerFactoryBean();
		ls.setDataSource(getDS());
		ls.setJpaProperties(hibconfig());
		
		HibernateJpaVendorAdapter hib=new HibernateJpaVendorAdapter();
		hib.setDatabase(Database.POSTGRESQL);
		
		ls.setJpaVendorAdapter(hib);
		ls.setPackagesToScan("com.nishant.springboot.hibernate.entity");
		return ls;
	}

}
