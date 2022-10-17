package com.example.consumo.app;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface ClientService {
	
	public <T> ResponseEntity<T> restTempleate(String url, Object data, HttpMethod method, Class <T> responseClass, String token);
	
	public <T> ResponseEntity<T> webclientPost( String url, String parametros, Class <T> responseClas )throws Exception;

}
