package com.allkhmernews.wep.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by MSI on 6/23/2017.
 */
//@Import(DatabaseConfiguration.class)
@Configuration
@MapperScan("com.allkhmernews.wep.repository")
public class MybastisConfig {
     @Autowired
    DataSource dataSource;
//    	@Autowired
//	private Environment env;
	
//	@Bean
//	@Profile("devDb")
//	public DataSource devDb(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("dev.datasource.driverClassName"));
//		dataSource.setUrl(env.getProperty("dev.datasource.url"));
//		dataSource.setUsername(env.getProperty("dev.datasource.username"));
//		dataSource.setPassword(env.getProperty("dev.datasource.password"));
//		return dataSource;
//	}
	
//	@Bean
//	@Profile("proDb")
//	public DataSource proDb(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("pro.datasource.driverClassName"));
//		dataSource.setUrl(env.getProperty("pro.datasource.url"));
//		dataSource.setUsername(env.getProperty("pro.datasource.username"));
//		dataSource.setPassword(env.getProperty("pro.datasource.password"));
//		return dataSource;
//	}
//	
//	@Bean
//	@Profile("memDb")
//	public DataSource inMemoryDb(){
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		builder.setType(EmbeddedDatabaseType.H2)
//			   .addScript("db/schema.sql")
//			   .addScript("db/data.sql");
//		return builder.build();
//	}
     
  

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return  sqlSessionFactoryBean;
    }
        @Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	
}
