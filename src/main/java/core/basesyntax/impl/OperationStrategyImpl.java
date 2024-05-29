package core.basesyntax.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;
import core.basesyntax.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = new HashMap<>(operationHandlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
