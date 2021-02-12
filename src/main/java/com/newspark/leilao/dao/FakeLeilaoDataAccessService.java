package com.newspark.leilao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.newspark.leilao.model.Leilao;

public class FakeLeilaoDataAccessService implements LeilaoDao {
  private static List<Leilao> DB = new ArrayList<>();

  @Override
  public int insereLeilao(UUID id, Leilao leilao) {
    DB.add(new Leilao(id, leilao.getDescricao(), leilao.getDia()));
    return 1;
  }

}
