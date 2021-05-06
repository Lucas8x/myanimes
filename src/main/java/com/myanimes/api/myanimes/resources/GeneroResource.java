package com.myanimes.api.myanimes.resources;

import java.net.URI;
import java.util.List;

import com.myanimes.api.myanimes.domain.Genero;
import com.myanimes.api.myanimes.services.GeneroService;

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
@RequestMapping("/genero")
public class GeneroResource {
  @Autowired
  private GeneroService generoService;

  @GetMapping
  public List<Genero> listar() {
    return generoService.listar();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Genero> buscarPorId(@PathVariable("id") Long idGenero) throws Exception {
    Genero genero = generoService.buscarPorId(idGenero);
    return ResponseEntity.ok(genero);
  }

  @PostMapping
  public ResponseEntity<Void> salvar(@RequestBody Genero genero) {
    generoService.salvar(genero);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(genero.getIdGenero()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public void atualizar(@RequestBody Genero genero) {
    generoService.atualizar(genero);
  }

  @DeleteMapping(value = "/{id}")
  public void deletar(@PathVariable("id") Long idGenero) throws Exception {
      generoService.deletarPorId(idGenero);
  }
}
