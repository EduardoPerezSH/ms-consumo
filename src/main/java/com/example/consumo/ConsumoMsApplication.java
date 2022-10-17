package com.example.consumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumoMsApplication {
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
	//cuando no se agrega codificacion en las properties se puede poner aqui 
	/*Genera el Bean para la codificacion del servicio*/
	/*@Bean 
	public CharacterEncodingFilter characterFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}*/

	
	public static void main(String[] args) {
		SpringApplication.run(ConsumoMsApplication.class, args);
	}

}
