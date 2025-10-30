package service.basesyntax.service.impl;

import java.util.Collections;
import java.util.Map;
import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.strategy.OperationHandler;
import service.basesyntax.service.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        if (map == null) {
            throw new IllegalArgumentException("map is null");
        }
        this.map = map;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("operation is null");
        }

        OperationHandler handler = map.get(operation);
        if (handler == null) {
            throw new RuntimeException("Operation " + operation + " not found");
        }
        return handler;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getMap() {
        return Collections.unmodifiableMap(map);
    }
}
