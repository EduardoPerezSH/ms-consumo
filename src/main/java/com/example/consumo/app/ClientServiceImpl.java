package com.example.consumo.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public <T> ResponseEntity<T> restTempleate(String url,  Object data, HttpMethod method, Class <T> responseClass, String token){
		

		ResponseEntity<T> response = null;
		String jsonTOobject = new Gson().toJson(data);
		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);

		
		HttpEntity<String> request = new HttpEntity<>(jsonTOobject, header);
		response = restTemplate.exchange(url, method, request, responseClass);
		
		
		return response;
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public <T> ResponseEntity<T> webclientPost( String url, String parametros, Class <T> responseClas ) throws Exception{
		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 200);
		
		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
				.defaultHeader(HttpHeaders.USER_AGENT, "app-atomic")
				.build()
				.method(HttpMethod.POST)
				.uri(url)
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue((Object) parametros)
				//.header(HttpHeaders.AUTHORIZATION, this.token)
				.exchange()
				.flatMap(response -> response.toEntity(responseClas)).block();

	}	

}
