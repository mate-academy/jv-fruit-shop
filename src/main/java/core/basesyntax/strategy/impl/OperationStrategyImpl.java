package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategy;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return strategy.get(operation);
    }
}
