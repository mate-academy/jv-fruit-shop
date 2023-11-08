package core.basesyntax.service.strategy;

import core.basesyntax.service.calculator.OperationCalculator;
import core.basesyntax.service.operation.FruitOperation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitOperation.Operation, OperationCalculator> handlers;

    public OperationStrategyImpl(Map<FruitOperation.Operation, OperationCalculator> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationCalculator getOperationType(FruitOperation fruitTransaction) {
        return handlers.get(fruitTransaction.getOperation());
    }
}

