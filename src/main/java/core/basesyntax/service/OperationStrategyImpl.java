package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
