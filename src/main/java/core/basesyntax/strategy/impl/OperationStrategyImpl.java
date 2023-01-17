package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationCalculator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationCalculator> operationHandlerMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationCalculator> operationHandlerMap
    ) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationCalculator getOperationHandler(FruitTransaction.Operation operation) {
        OperationCalculator operationCalculator = operationHandlerMap.get(operation);
        if (operationCalculator == null) {
            throw new RuntimeException("Invalid input operation");
        }
        return operationCalculator;
    }
}
