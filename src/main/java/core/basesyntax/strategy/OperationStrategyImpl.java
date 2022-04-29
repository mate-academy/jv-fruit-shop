package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
