package strategy;

import java.util.Map;
import model.Operation;
import service.OperationHandler;

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
