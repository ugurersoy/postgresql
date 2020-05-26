package com.ersoy.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ersoy.postgresql.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
