package com.intelygenz.numbers.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.intelygenz.numbers.domain.NumbersRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class NumbersBinaryOrderServiceShould {

  @Autowired NumbersBinaryOrderService numbersBinaryOrderService;

  @MockBean NumbersRepository numbersRepository;

  @Test
  public void testGetNumbersOrdered() {
    List<Integer> numbers = Arrays.asList(1, 15, 5, 7, 3);
    when(numbersRepository.findNumbers()).thenReturn(numbers);

    List<Integer> orderedNumbers = numbersBinaryOrderService.getNumbersOrderedByBitCount();

    List<Integer> expected = Arrays.asList(15, 7, 3, 5, 1);

    assertEquals(expected, orderedNumbers);
  }

  @Test
  public void testGetNumbersOrdered_EmptyList() {
    when(numbersRepository.findNumbers()).thenReturn(new ArrayList<>());

    List<Integer> orderedNumbers = numbersBinaryOrderService.getNumbersOrderedByBitCount();

    assertEquals(Collections.emptyList(), orderedNumbers);
  }
}
