package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        if (operationHandlerMap == null) {
            throw new RuntimeException("OperationHandlerMap can`t be null");
        }

        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operationType) {
        if (operationType == null) {
            throw new RuntimeException("Operation type can`t be null");
        }

        return operationHandlerMap.get(operationType);
    }
}
