package com.example.consumo.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RemoveRepeatedServiceImpl implements RemoveRepeatedService {

	private final Logger logger = LoggerFactory.getLogger(RemoveRepeatedServiceImpl.class);

	public String removeRepeatedLetters(String text) {
		
		String[] arrayCadena = text.split(""); 
		//ordenamiento inverso
		Arrays.sort(arrayCadena, Collections.reverseOrder(null));
		String newCadena = "";
		
		for(int e=0; e< arrayCadena.length; e++) {
			
			if(!newCadena.contains(arrayCadena[e])) {
				newCadena = newCadena + arrayCadena[e];
			}
		}
		
		logger.info(newCadena);
		return newCadena;
	}
	
	public String removeRepeatedLettersLamda(String text) {
		
		List<String> listString = Arrays.asList(text.split(""));
		
		//Streem para quitar las letras repedidas de la lista y convertir lista a string con collect y ordenando con la lista con sorted
		String newCadena=listString.stream().distinct().map(Object::toString).sorted().collect(Collectors.joining());

		logger.info(newCadena);
		return newCadena;
	}
	
	public String firstNotRepeated(String text) {

		String newText = "-";
		for(int a=0; a<text.length(); a++) {
			Integer cont= 0;
			for(int i=0; i<text.length(); i++) {
				
				if(text.charAt(a)==text.charAt(i)) {
					cont +=1;
				}
			}
			if(cont ==1) {
				newText = String.valueOf(text.charAt(a));
				break;
			}
		}
		
		return newText;
	}
	
	public String firstNotRepeatedStrem(String text) {
		String newText = "-";
		List<String> listText = Arrays.asList(text.split(""));
		
		//String newText2 = listText.stream().map(a-> a.).findFirst().get();
		//newText= d.get();
		return newText;
	}
}
