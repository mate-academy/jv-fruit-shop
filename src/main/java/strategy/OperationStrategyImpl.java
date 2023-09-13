package strategy;

import java.util.Map;
import model.Operation;
import service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(
            Map<Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Unknown operation!");
        }
        return operationOperationHandlerMap.get(operation);
    }
}
