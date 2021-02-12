package com.newspark.leilao.service;

import com.newspark.leilao.dao.LeilaoDao;
import com.newspark.leilao.model.Leilao;

public class LeilaoService {

  private final LeilaoDao leilaoDao;

  public LeilaoService(LeilaoDao leilaoDao) {
    this.leilaoDao = leilaoDao;
  }

  public int addLeilao(Leilao leilao) {
    return leilaoDao.insereLeilao(leilao);
  }
}
