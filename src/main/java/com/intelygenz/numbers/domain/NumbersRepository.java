package com.intelygenz.numbers.domain;

import java.util.List;

public interface NumbersRepository {

  List<Integer> findNumbers();
}
