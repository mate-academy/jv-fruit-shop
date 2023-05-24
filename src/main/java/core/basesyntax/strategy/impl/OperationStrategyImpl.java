package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationProcessor> strategy;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationProcessor> strategy) {
        this.strategy = strategy;
    }

    @Override
    public OperationProcessor get(FruitTransaction.Operation operation) {
        validateOperation(operation);
        return strategy.get(operation);
    }

    private void validateOperation(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation is null in "
                    + getClass().getSimpleName());
        }
    }
}
