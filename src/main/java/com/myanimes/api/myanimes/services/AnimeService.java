package com.myanimes.api.myanimes.services;

import java.util.List;

import com.myanimes.api.myanimes.domain.Anime;
import com.myanimes.api.myanimes.repository.AnimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {
  @Autowired
  private AnimeRepository animeRepository;

  public List<Anime> listar() {
    return animeRepository.findAll();
  }

  public Anime salvar(Anime anime) {
    Anime animeNovo = animeRepository.save(anime);
    return animeNovo;
  }

  public Anime atualizar(Anime anime) {
    Anime animeAtualizado = animeRepository.save(anime);
    return animeAtualizado;
  }

  public void deletarPorId(Long idAnime) throws Exception {
    animeRepository.findById(idAnime)
      .orElseThrow(() -> new Exception("Nenhum anime encontrado."));
    animeRepository.deleteById(idAnime);
  }

  public Anime buscarPorId(Long idAnime) throws Exception {
    return animeRepository.findById(idAnime)
      .orElseThrow(() -> new Exception("Nenhum anime encontrado."));
  }
}
