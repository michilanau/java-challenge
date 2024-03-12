package com.intelygenz.numbers.application;

import com.intelygenz.numbers.domain.NumbersRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NumbersBinaryOrderService {

  NumbersRepository numbersRepository;

  public List<Integer> getNumbersOrderedByBitCount() {

    List<Integer> numbers = numbersRepository.findNumbers();

    if (numbers.isEmpty()) {
      return Collections.emptyList();
    }

    Collections.sort(
        numbers,
        Comparator.comparingInt(Integer::bitCount).reversed().thenComparingInt(number -> number));

    return numbers;
  }
}
