package com.newspark.leilao.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.newspark.leilao.model.Leilao;
import com.newspark.leilao.service.LeilaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/leilao")
@RestController
public class LeilaoController {
  private final LeilaoService leilaoService;

  @Autowired
  public LeilaoController(LeilaoService leilaoService) {
    this.leilaoService = leilaoService;
  }

  @PostMapping
  public void addLeilao(@RequestBody @Valid @NonNull Leilao leilao) {
    this.leilaoService.addLeilao(leilao);
  }

  @GetMapping
  public List<Leilao> getAllLeiloes() {
    return leilaoService.getLeiloes();
  }

  @GetMapping(path = "{id}")
  public Leilao getLeilaoById(@PathVariable("id") UUID id) {
    return leilaoService.getLeilaoById(id).orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deleteLeilaoById(@PathVariable("id") UUID id) {
    leilaoService.deletaLeilao(id);
  }

  @PutMapping(path = "{id}")
  public void updateLeilaoById(@PathVariable("id") UUID id, @RequestBody @Valid @NonNull Leilao newLeilao) {
    leilaoService.updateLeilaoById(id, newLeilao);
  }
}
