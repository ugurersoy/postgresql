package com.ersoy.postgresql.dto;

import java.util.List;

import com.ersoy.postgresql.entity.Address;

import lombok.Data;


@Data
public class PersonelDto {

    private Long id;
	
	private String name;

	private String surname;
	
	private List<String> Addresses;
}
