package com.ersoy.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ersoy.postgresql.entity.Personel;

@Repository
public interface PersonelRepository extends JpaRepository<Personel,Long> {

}
