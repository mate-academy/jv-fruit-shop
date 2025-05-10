package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Operation, OperationHandler> operationOperationHandlerMap;

    public StrategyImpl(Map<Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
