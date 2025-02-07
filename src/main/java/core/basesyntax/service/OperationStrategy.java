package core.basesyntax.service;

import java.util.Map;

public interface OperationStrategy {
    void execute(FruitTransaction fruitTransaction, Map<String, Integer> fruitRepository);
}
