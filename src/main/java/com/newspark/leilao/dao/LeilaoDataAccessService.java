package com.newspark.leilao.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.newspark.leilao.model.Leilao;

import org.springframework.stereotype.Repository;

@Repository("postgres")
public class LeilaoDataAccessService implements LeilaoDao {

  @Override
  public int insereLeilao(UUID id, Leilao leilao) {
    return 0;
  }

  @Override
  public List<Leilao> selecionaTodosLeiloes() {
    return List.of(new Leilao(UUID.randomUUID(), "FROM POSTGRES DB", new Date()));
  }

  @Override
  public Optional<Leilao> selecionaLeilaoById(UUID id) {
    return null;
  }

  @Override
  public int deletaLeilao(UUID id) {
    return 0;
  }

  @Override
  public int updateLeilaoById(UUID id, Leilao leilao) {
    return 0;
  }

}
