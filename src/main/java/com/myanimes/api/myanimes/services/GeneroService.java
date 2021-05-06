package com.myanimes.api.myanimes.services;

import java.util.List;

import com.myanimes.api.myanimes.domain.Genero;
import com.myanimes.api.myanimes.repository.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
  @Autowired
  private GeneroRepository generoRepository;

  public List<Genero> listar() {
    return generoRepository.findAll();
  }

  public Genero salvar(Genero genero) {
    Genero generoNovo = generoRepository.save(genero);
    return generoNovo;
  }

  public Genero atualizar(Genero genero) {
    Genero generoAtualizado = generoRepository.save(genero);
    return generoAtualizado;
  }

  public void deletarPorId(Long idGenero) throws Exception {
    generoRepository.findById(idGenero)
      .orElseThrow(() -> new Exception("Nenhum genero encontrado."));
    generoRepository.deleteById(idGenero);
  }

  public Genero buscarPorId(Long idGenero) throws Exception {
    return generoRepository.findById(idGenero)
      .orElseThrow(() -> new Exception("Nenhum genero encontrado."));
  }
}
