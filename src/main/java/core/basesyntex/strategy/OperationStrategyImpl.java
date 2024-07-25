package core.basesyntex.strategy;

import core.basesyntex.model.Operation;
import core.basesyntex.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return operationHandlers.get(operation);
    }
}
