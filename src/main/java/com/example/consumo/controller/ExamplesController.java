package com.example.consumo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.consumo.app.RemoveRepeatedService;

@Controller
@RequestMapping("/examples")
public class ExamplesController {

	@Autowired
	private RemoveRepeatedService examplesService;
	
	@GetMapping("/cadena/repetida")
	public ResponseEntity<Map<String, Object>> cadenaRepetida(String cadena){

		String responseCadena = examplesService.removeRepeatedLetters(cadena);
		String responseCadenaAdd = examplesService.removeRepeatedLettersLamda(cadena);
		String responseFirst = examplesService.firstNotRepeated(cadena);
		String responseFirstWhitStrem = examplesService.firstNotRepeatedStrem(cadena);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("simple", responseCadena);
		response.put("whit Strem", responseCadenaAdd);
		response.put("first not repead", responseFirst);
		response.put("first not repead whit strem", responseFirstWhitStrem);
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}
}
