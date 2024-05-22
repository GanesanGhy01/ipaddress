package com.api.calling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@Autowired
	ApiService service;
	
	@PostMapping("save")
	public ResponseEntity<String> register(@RequestBody Apipojo api) {
		return service.saveData(api);
	}
	
	@GetMapping("getdata")
	public ResponseEntity<List<Apipojo>> getData(){
		return service.getAllData();
	}
}
