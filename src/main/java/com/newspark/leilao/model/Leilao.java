package com.newspark.leilao.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class Leilao {
  private final UUID id;

  @NotBlank
  private final String descricao;

  private final Date dia;

  public Leilao(@JsonProperty("id") UUID id, @JsonProperty("descricao") String descricao,
      @JsonProperty("dia") Date dia) {
    this.id = id;
    this.descricao = descricao;
    this.dia = dia;
  }

  public UUID getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public Date getDia() {
    return dia;
  }
}
