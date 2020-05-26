package com.ersoy.postgresql.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ersoy.postgresql.dto.PersonelDto;

public interface PersonelService {
	
	PersonelDto save (PersonelDto personelDto);
	

	List<PersonelDto> getAll();
	
	List<PersonelDto> getAll(Pageable pageable);

	void delete(Long id);
}
