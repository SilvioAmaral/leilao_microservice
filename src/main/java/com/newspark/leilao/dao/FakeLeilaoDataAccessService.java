package com.newspark.leilao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.newspark.leilao.model.Leilao;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeLeilaoDataAccessService implements LeilaoDao {
  private static List<Leilao> DB = new ArrayList<>();

  @Override
  public int insereLeilao(UUID id, Leilao leilao) {
    DB.add(new Leilao(id, leilao.getDescricao(), leilao.getDia()));
    return 1;
  }

  @Override
  public List<Leilao> selecionaTodosLeiloes() {
    return DB;
  }

  @Override
  public Optional<Leilao> selecionaLeilaoById(UUID id) {
    return DB.stream().filter(leilao -> leilao.getId().equals(id)).findFirst();
  }

  @Override
  public int deletaLeilao(UUID id) {
    Optional<Leilao> leilaoMaybe = selecionaLeilaoById(id);
    if (leilaoMaybe.isEmpty()) {
      return 0;
    }
    DB.remove(leilaoMaybe.get());
    return 1;
  }

  @Override
  public int updateLeilaoById(UUID id, Leilao leilao) {
    return selecionaLeilaoById(id).map(l -> {
      int indexToUpdate = DB.indexOf(l);
      if (indexToUpdate >= 0) {
        DB.set(indexToUpdate, new Leilao(id, leilao.getDescricao(), leilao.getDia()));
        return 1;
      }
      return 0;
    }).orElse(0);
  }

}
