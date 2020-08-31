package core.basesyntax.service;

import java.util.Map;

public interface FruitOperations {
    boolean operations(Map<String, Map<String, Integer>> fruits, FruitDto dto);
}
