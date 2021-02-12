package com.newspark.leilao.api;

import com.newspark.leilao.model.Leilao;
import com.newspark.leilao.service.LeilaoService;

public class LeilaoController {
  private final LeilaoService leilaoService;

  public LeilaoController(LeilaoService leilaoService) {
    this.leilaoService = leilaoService;
  }

  public void addLeilao(Leilao leilao) {
    this.leilaoService.addLeilao(leilao);
  }

}
