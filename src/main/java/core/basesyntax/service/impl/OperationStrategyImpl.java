package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
