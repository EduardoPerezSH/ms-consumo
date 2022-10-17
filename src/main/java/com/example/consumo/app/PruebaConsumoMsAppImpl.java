package com.example.consumo.app;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.consumo.vo.ConsumoVO;
import com.google.gson.Gson;

@Service
public class PruebaConsumoMsAppImpl implements PruebaConsumoMsApp {

	@Autowired
	private ClientService clientService;
	
	@Value("${consumo.ms.prueba.ip}")
	private String url;
	
	private final Logger logger = LoggerFactory.getLogger(PruebaConsumoMsAppImpl.class);
	
	@Override
	public Object consumeRestTemplate() {
		Map<String, Object> request = new HashMap<>();
		
		request.put("idClient", 45445);
		request.put("idStatus", 7777);
		request.put("idClientSiglo", 897);
		ResponseEntity<String>  response = clientService.restTempleate(url, request, HttpMethod.POST, String.class, null);
		
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			//Gson gson = new Gson();
			
			//List<String> lista =  gson.fromJson(response.getBody(), List.class) ;

			
			//conversion de datos de Json a Vo
			/*for(int i = 0; i < lista.size(); i++ ) {
				VO vo = new VO();
				vo = gson.fromJson(gson.toJson(lista.get(i)), VO.class);
				voList.add(vo);
			}*/
		}else {
			logger.error(response.getStatusCode() + "  mensaje: "+response.getBody());
		}
		
		return response;
	}
	
	@Override
	public Object consumoMsWebCliente() {
		
		Object objeto = new Object();
		try {
		ConsumoVO consumoVO = new ConsumoVO();
		consumoVO.setNombre("lalo");
		
		JSONObject jsonTOobject = new JSONObject(new Gson().toJson(consumoVO));
		
		ResponseEntity<String> response = clientService.webclientPost(url, jsonTOobject.toString(), String.class);
		
		
	
		objeto = response.getBody();
		
		}catch(Exception e) {
			logger.error( e.toString());
		}
		return objeto;
	}
 
}
