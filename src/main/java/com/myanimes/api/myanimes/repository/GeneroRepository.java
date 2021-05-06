package com.myanimes.api.myanimes.repository;

import com.myanimes.api.myanimes.domain.Genero;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long>{
  
}
