package com.newspark.leilao.dao;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import com.newspark.leilao.model.Leilao;

public interface LeilaoDao {
  int insereLeilao(UUID id, Leilao leilao);

  default int insereLeilao(Leilao leilao) {
    UUID id = UUID.randomUUID();
    return insereLeilao(id, leilao);
  }

  List<Leilao> selecionaTodosLeiloes();

  Optional<Leilao> selecionaLeilaoById(UUID id);

  int deletaLeilao(UUID id);

  int updateLeilaoById(UUID id, Leilao leilao);
}
