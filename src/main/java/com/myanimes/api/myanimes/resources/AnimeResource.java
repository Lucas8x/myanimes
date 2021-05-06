package com.myanimes.api.myanimes.resources;

import java.net.URI;
import java.util.List;

import com.myanimes.api.myanimes.domain.Anime;
import com.myanimes.api.myanimes.services.AnimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/anime")
public class AnimeResource {
  @Autowired
  private AnimeService animeService;

  @GetMapping
  public List<Anime> listar() {
    return animeService.listar();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Anime> buscarPorId(@PathVariable("id") Long idAnime) throws Exception {
    Anime anime = animeService.buscarPorId(idAnime);
    return ResponseEntity.ok(anime);
  }

  @PostMapping
  public ResponseEntity<Void> salvar(@RequestBody Anime anime) {
    animeService.salvar(anime);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(anime.getIdAnime()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public void atualizar(@RequestBody Anime anime) {
    animeService.atualizar(anime);
  }

  @DeleteMapping(value = "/{id}")
  public void deletar(@PathVariable("id") Long idAnime) throws Exception {
    animeService.deletarPorId(idAnime);
  }
}
