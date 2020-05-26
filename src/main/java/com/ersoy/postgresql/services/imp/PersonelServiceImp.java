package com.ersoy.postgresql.services.imp;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.ersoy.postgresql.dto.PersonelDto;
import com.ersoy.postgresql.entity.Address;
import com.ersoy.postgresql.entity.Personel;
import com.ersoy.postgresql.repository.AddressRepository;
import com.ersoy.postgresql.repository.PersonelRepository;
import com.ersoy.postgresql.services.PersonelService;

@Service
public class PersonelServiceImp implements PersonelService{

	@Autowired
	private PersonelRepository repo;
	
	private AddressRepository addressRepo;
	
	@Override
	@Transactional
	public PersonelDto save(PersonelDto personelDto) {
		
		//Assert.isNull(personelDto.getName(),"name can not be null");
		// TODO Auto-generated method stub
		Personel per = new Personel();
		per.setName(personelDto.getName());
		per.setSurname(personelDto.getSurname());
		
		final Personel perR =repo.save(per);
		
		
		List<Address> a = new ArrayList<>();
		personelDto.getAddresses().forEach(item->{
			Address ad =new Address();
			ad.setAddres(item);
			ad.setAddressType(Address.AddressType.HOME);
			ad.setIsActive(true);
			ad.setPersonel(perR);
			a.add(ad);	
		});
		addressRepo.saveAll(a);
		
		personelDto.setId(perR.getId());
		return personelDto;
	}

	@Override
	public List<PersonelDto> getAll() {

		List<Personel> personels = repo.findAll();
		List<PersonelDto> personelDtos = new ArrayList<>();
		 personels.forEach(item ->{
			 PersonelDto perDto = new PersonelDto();
			 perDto.setId(item.getId());
			 perDto.setName(item.getName());
			 perDto.setSurname(item.getSurname());
			 perDto.setAddresses(item.getAddresses().stream()
					 .map(Address::getAddres).collect(Collectors.toList()));
			 personelDtos.add(perDto);
		 });
		
		return personelDtos;
	}

	@Override
	public List<PersonelDto> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
