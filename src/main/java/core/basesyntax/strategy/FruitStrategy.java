package core.basesyntax.strategy;

import java.util.Map;

public interface FruitStrategy {

    void process(Map<String, Integer> dataBase, String fruit, int quantity);
}
