package core.basesyntax.service.impl;

import core.basesyntax.entity.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.quantity.handlers.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {

    private static final String ARGUMENT_IS_NULL_ERROR_MESSAGE = "Argument must not be null";
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        Optional.ofNullable(operationHandlerMap)
                .orElseThrow(() -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + operationHandlerMap));
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler operate(Operation operation) {
        Optional.ofNullable(operation)
                .orElseThrow(() -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + operation));
        return operationHandlerMap.get(operation);
    }
}
