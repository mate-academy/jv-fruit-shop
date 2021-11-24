package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandler) {
        this.operationHandlers = operationHandler;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlers.get(operation);
    }
}
