package com.newspark.leilao.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.newspark.leilao.model.Leilao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class LeilaoDataAccessService implements LeilaoDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public LeilaoDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insereLeilao(UUID id, Leilao leilao) {
    final String sql = "INSERT INTO leilao(id, descricao, dia) VALUES (?, ?, ?);";
    return jdbcTemplate.update(sql, id, leilao.getDescricao(), leilao.getDia());
  }

  @Override
  public List<Leilao> selecionaTodosLeiloes() {
    final String getAll = "SELECT id, descricao, dia FROM leilao;";
    return jdbcTemplate.query(getAll, (resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      String desc = resultSet.getString("descricao");
      Date dia = resultSet.getDate("dia");
      return new Leilao(id, desc, dia);
    });
  }

  @Override
  public Optional<Leilao> selecionaLeilaoById(UUID id) {
    final String getById = "SELECT id, descricao, dia FROM leilao WHERE id=?;";
    var leilao = jdbcTemplate.queryForObject(getById, (resultSet, i) -> {
      String desc = resultSet.getString("descricao");
      Date dia = resultSet.getDate("dia");
      return new Leilao(id, desc, dia);
    }, new Object[] { id });
    return Optional.ofNullable(leilao);
  }

  @Override
  public int deletaLeilao(UUID id) {
    final String sql = "DELETE FROM leilao WHERE id = ?;";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public int updateLeilaoById(UUID id, Leilao leilao) {
    final String sql = "UPDATE leilao SET descricao = ?, dia = ? WHERE id = ?;";
    return jdbcTemplate.update(sql, leilao.getDescricao(), leilao.getDia(), id);
  }

}
