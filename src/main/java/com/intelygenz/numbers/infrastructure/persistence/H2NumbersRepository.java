package com.intelygenz.numbers.infrastructure.persistence;

import com.intelygenz.numbers.domain.NumbersRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2NumbersRepository implements NumbersRepository {

  @Autowired JdbcTemplate jdbcTemplate;

  @Override
  public List<Integer> findNumbers() {
    String sql = "SELECT integers FROM NUMBERS";

    List<String> numbersList = jdbcTemplate.queryForList(sql, String.class);

    if (numbersList.get(0) != null) {
      return Arrays.stream(numbersList.get(0).split(","))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
    } else {
      return Collections.emptyList();
    }
  }
}
