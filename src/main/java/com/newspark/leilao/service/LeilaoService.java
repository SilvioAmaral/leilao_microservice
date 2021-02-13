package com.newspark.leilao.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.newspark.leilao.dao.LeilaoDao;
import com.newspark.leilao.model.Leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LeilaoService {

  private final LeilaoDao leilaoDao;

  @Autowired
  public LeilaoService(@Qualifier("postgres") LeilaoDao leilaoDao) {
    this.leilaoDao = leilaoDao;
  }

  public int addLeilao(Leilao leilao) {
    return leilaoDao.insereLeilao(leilao);
  }

  public List<Leilao> getLeiloes() {
    return leilaoDao.selecionaTodosLeiloes();
  }

  public Optional<Leilao> getLeilaoById(UUID id) {
    return leilaoDao.selecionaLeilaoById(id);
  }

  public int deletaLeilao(UUID id) {
    return leilaoDao.deletaLeilao(id);
  }

  public int updateLeilaoById(UUID id, Leilao newLeilao) {
    return leilaoDao.updateLeilaoById(id, newLeilao);
  }
}
