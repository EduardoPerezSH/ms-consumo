package com.example.consumo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.consumo.app.RemoveRepeatedService;
import com.example.consumo.app.PruebaConsumoMsApp;

@Controller
@RequestMapping("/consumo")
public class ConsumoMsController {

	@Autowired
	private PruebaConsumoMsApp pruebaConsumoMsApp;
	
	@Autowired
	private RemoveRepeatedService examplesService;
	
	@PostMapping("/restTemplate")
	public ResponseEntity<Map<String, Object>>  consumoMsRestTemplate(String nombre){
	

		Object respuesta = pruebaConsumoMsApp.consumeRestTemplate();

		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", respuesta);
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/webClient")
	public ResponseEntity<Map<String, Object>> consumoMsWebclient(){

		Object datos = pruebaConsumoMsApp.consumoMsWebCliente();

		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", datos.toString());
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}

}
