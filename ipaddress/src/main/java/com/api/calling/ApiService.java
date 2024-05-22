package com.api.calling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<String> saveData(Apipojo apipojo) {
		
		String api = "http://192.168.1.5:9900/insert";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(api, apipojo, String.class);
		return responseEntity;
	}
	
	public ResponseEntity<List<Apipojo>> getAllData(){
		String url = "http://192.168.1.5:9900/fetchall";
		ResponseEntity<List<Apipojo>> responseEntity = restTemplate.exchange(
		        url,
		        HttpMethod.GET,
		        null,
		        new ParameterizedTypeReference<List<Apipojo>>() {}
		    );
		return responseEntity;
	}
}
