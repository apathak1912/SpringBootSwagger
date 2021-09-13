package com.restapi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "MySQLentityManagerFactory",basePackages = {"com.restapi.mysql.reposetry"})
public class MySQLConfig {

	@Bean(name = "mysqldataSource")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "MySQLentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqldataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.restapi.entity").persistenceUnit("MySQL").build();
	}
	
	@Bean(name = "MySQLTransactionManager")
	  public PlatformTransactionManager mySQLTransactionManager(
	    @Qualifier("MySQLentityManagerFactory") EntityManagerFactory
	    mySQLEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(mySQLEntityManagerFactory);
	  }
}
