package core.basesyntax.db;

import core.basesyntax.enums.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitQuantities = new HashMap<>();
    private Map<Operation, OperationStrategy> strategies;

    public Storage(Map<Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public void update(String fruit, int quantity, Operation operation) {
        OperationStrategy strategy = strategies.get(operation);
        strategy.apply(fruit, quantity, this);
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitQuantities;
    }
}
