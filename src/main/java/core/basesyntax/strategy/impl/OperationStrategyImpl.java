package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        if (operationHandlers != null) {
            operationHandlerMap = operationHandlers;
        } else {
            operationHandlerMap = new HashMap<>();
        }
    }

    public OperationHandler getHandlerForTransaction(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
