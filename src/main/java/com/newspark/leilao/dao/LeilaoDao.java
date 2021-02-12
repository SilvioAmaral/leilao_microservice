package com.newspark.leilao.dao;

import java.util.UUID;

import com.newspark.leilao.model.Leilao;

public interface LeilaoDao {
  int insereLeilao(UUID id, Leilao leilao);

  default int insereLeilao(Leilao leilao) {
    UUID id = UUID.randomUUID();
    return insereLeilao(id, leilao);
  }
}
