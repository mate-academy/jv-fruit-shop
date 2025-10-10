package core.basesyntax.serviceimpl;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Collections;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        if (operationHandlerMap == null) {
            throw new RuntimeException("Operation handler map must not be null");
        }
        if (operationHandlerMap.isEmpty()) {
            throw new RuntimeException("Operation handler map must contain at least one handler");
        }
        this.operationHandlerMap = Collections.unmodifiableMap(operationHandlerMap);
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation must not be null");
        }

        OperationHandler handler = operationHandlerMap.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler found for operation '" + operation
                    + "'. Supported operations: " + operationHandlerMap.keySet());
        }

        return handler;
    }
}
