package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface FruitsCalculator {
    Map<String, Integer> parseAndCalculate(List<String> data);
}
