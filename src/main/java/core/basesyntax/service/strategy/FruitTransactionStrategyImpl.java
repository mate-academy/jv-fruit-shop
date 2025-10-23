package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import java.util.LinkedHashMap;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private final Map<Operation, FruitTransactionHandler> map;

    public FruitTransactionStrategyImpl(Map<Operation, FruitTransactionHandler> map) {
        if (map == null) {
            throw new RuntimeException("Operation handlers map must not be null");
        }
        this.map = new LinkedHashMap<>(map);
    }

    @Override
    public FruitTransactionHandler get(Operation type) {
        if (type == null) {
            throw new RuntimeException("Operation type must not be null");
        }
        FruitTransactionHandler fruitTransactionHandler = map.get(type);
        if (fruitTransactionHandler == null) {
            throw new RuntimeException("No handler registered for operation: " + type);
        }
        return fruitTransactionHandler;
    }
}
