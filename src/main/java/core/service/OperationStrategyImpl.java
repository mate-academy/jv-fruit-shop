package core.service;

import core.model.FruitTransaction;
import core.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
