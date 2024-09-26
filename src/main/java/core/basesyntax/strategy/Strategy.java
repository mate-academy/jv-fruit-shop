package core.basesyntax.strategy;

import java.util.Map;

public interface Strategy {
    void processData(Map<String, Integer> fruitData, String fruit, int quantity);
}
