package com.restapi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "MySQLentityManagerFactory",transactionManagerRef = "MySQLTransactionManager",basePackages = {"com.restapi.sql.reposetry"})
public class MySQLConfig {

	@Autowired
	Environment env;

	@Bean(name = "mysqldataSource")
	//@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource dataSource() {

		return DataSourceBuilder.create()
				.driverClassName(env.getProperty("datasource.driver"))
				.url(env.getProperty("datasource.url"))
				.username(env.getProperty("datasource.username"))
				.password(env.getProperty("datasource.password"))
				.build();
	}
	
	@Bean(name = "MySQLentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqldataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
				.dataSource(dataSource)
				.packages("com.restapi.entity")
				.persistenceUnit("MySql").build();
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getProperty("datasource.dialect"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("datasource.ddl-auto"));
		jpaProperties.put("hibernate.show-sql", env.getProperty("datasource.show-sql"));
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean(name = "MySQLTransactionManager")
	  public PlatformTransactionManager mySQLTransactionManager(
	    @Qualifier("MySQLentityManagerFactory") EntityManagerFactory
	    mySQLEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(mySQLEntityManagerFactory);
	  }
}
