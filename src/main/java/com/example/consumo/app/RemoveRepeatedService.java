package com.example.consumo.app;

public interface RemoveRepeatedService {

	/**
	 * Clase eliminar los letras repetidas de acuerdo a una cadena de entrada
	 * resuelto de la forma clasica con un ciclo for
	 * @param text con valores repetidos
	 * @return String con valores no repetidos
	 */
	public String removeRepeatedLetters(String text);
	
	/**
	 * Clase eliminar los letras repetidas de acuerdo a una cadena de entrada
	 * resuelto con lamdas
	 * @param text
	 * @return String con valores no repetidos
	 */
	public String removeRepeatedLettersLamda(String text);
	
	
	/**
	 * Clase para encontrar el primero caracter no repetido de la cadena
	 * @param text
	 * @return String con valores no repetidos
	 */
	public String firstNotRepeated(String text);
	
	/**
	 * Clase para encontrar el primero caracter no repetido de la cadena
	 * resulto con strem or lambda
	 * @param text
	 * @return String con valores no repetidos
	 */
	public String firstNotRepeatedStrem(String text);
	
}
