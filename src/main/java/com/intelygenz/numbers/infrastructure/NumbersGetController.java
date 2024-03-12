package com.intelygenz.numbers.infrastructure;

import com.intelygenz.numbers.application.NumbersBinaryOrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NumbersGetController {

  NumbersBinaryOrderService numbersBitCountOrderService;

  @GetMapping("/numbers")
  public ResponseEntity<List<Integer>> findSensorCounter() {

    return ResponseEntity.ok().body(numbersBitCountOrderService.getNumbersOrderedByBitCount());
  }
}
