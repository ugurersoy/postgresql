package com.ersoy.postgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ersoy.postgresql.dto.PersonelDto;
import com.ersoy.postgresql.services.PersonelService;

@RestController
@RequestMapping("/personel")
public class PersonelController {
	
	@Autowired
	PersonelService perService;
	
	@PostMapping
	public 	ResponseEntity<PersonelDto> insert(@RequestBody PersonelDto item){
	
		return ResponseEntity.ok(perService.save(item));
	} 
	
	
	@GetMapping
	public ResponseEntity<List<PersonelDto>> getAll(){
		
		return ResponseEntity.ok(perService.getAll());
	}

}
