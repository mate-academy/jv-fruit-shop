package core.basesyntax.strategy;

import core.basesyntax.Operation;
import core.basesyntax.operationhandlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
