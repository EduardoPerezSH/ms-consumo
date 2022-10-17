package com.example.consumo.configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Value("${trut.store.password}")
	private String trutStorePassword;
	
	@Value("${trut.store}")
	private String trutStore;
	
	//configuracion para realizar peticion https con certificado.
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
	CertificateException, MalformedURLException, IOException {
		
		SSLContext sslContext = new SSLContextBuilder()
				.loadTrustMaterial(ResourceUtils.getFile(trutStore), trutStorePassword.toCharArray())
				.build();
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.custom()
                  .setSSLHostnameVerifier(new DefaultHostnameVerifier())
                  .setSSLContext(sslContext)
                  .build());
		requestFactory.setConnectTimeout(10000);
		requestFactory.setReadTimeout(10000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
 
        return restTemplate;
	}
}
