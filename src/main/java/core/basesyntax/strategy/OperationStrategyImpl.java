package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationOperationsHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationsHandlerMap) {
        this.operationOperationsHandlerMap = operationOperationsHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        OperationHandler handler = operationOperationsHandlerMap.get(operation);

        if (handler == null) {
            throw new IllegalArgumentException("No handler found for operation: " + operation);
        }

        return handler;
    }
}
