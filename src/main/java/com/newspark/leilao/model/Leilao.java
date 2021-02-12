package com.newspark.leilao.model;

import java.util.Date;
import java.util.UUID;

public class Leilao {
  private final UUID id;
  private final String descricao;
  private final Date dia;

  public Leilao(UUID id, String descricao, Date dia) {
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
