package com.example.consumo.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig conexion() {
		return new HikariConfig();
	}
	
	@Bean(name = "LaloDataSource")
	public DataSource datasource(HikariConfig hikariConfig) {
		hikariConfig.setPassword(hikariConfig.getPassword());//esto se hace cuando se tiene la contraseña encriptada
		return new HikariDataSource(hikariConfig);
	}
}
