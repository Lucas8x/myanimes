package com.myanimes.api.myanimes.repository;

import com.myanimes.api.myanimes.domain.Anime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
  
}
