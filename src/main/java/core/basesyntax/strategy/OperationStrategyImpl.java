package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation.OperationKind, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation.OperationKind,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation.OperationKind operationKind) {
        return operationHandlerMap.get(operationKind);
    }
}
