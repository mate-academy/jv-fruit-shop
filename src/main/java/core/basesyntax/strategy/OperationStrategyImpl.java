package core.basesyntax.strategy;

import core.basesyntax.db.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    public OperationHandler getHandler(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
