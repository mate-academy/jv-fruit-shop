package operation;

import java.util.Map;
import model.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
