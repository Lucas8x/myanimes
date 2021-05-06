package com.myanimes.api.myanimes.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="anime")
public class Anime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAnime;
  private String titulo;
  private String tipo;
  private String estudio;
  private Integer classificacao;
  @Column(length=250)
  private String sinopse;
  @Temporal(TemporalType.DATE)
  private Date dataLancamento;

  @OneToMany(mappedBy="anime")
  private List<Genero> generos;

  public Anime() {}

  public Anime(Long idAnime, String titulo, String tipo, String estudio, Integer classificacao, String sinopse, Date dataLancamento) {
    this.idAnime = idAnime;
    this.titulo = titulo;
    this.tipo = tipo;
    this.estudio = estudio;
    this.classificacao = classificacao;
    this.sinopse = sinopse;
    this.dataLancamento = dataLancamento;
  }

  public Long getIdAnime() {
    return idAnime;
  }

  public void setIdAnime(Long idAnime) {
    this.idAnime = idAnime;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getEstudio() {
    return estudio;
  }

  public void setEstudio(String estudio) {
    this.estudio = estudio;
  }

  public Integer getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(Integer classificacao) {
    this.classificacao = classificacao;
  }

  public String getSinopse() {
    return sinopse;
  }

  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }

  public Date getDataLancamento() {
    return dataLancamento;
  }

  public void setDataLancamento(Date dataLancamento) {
    this.dataLancamento = dataLancamento;
  }

}
