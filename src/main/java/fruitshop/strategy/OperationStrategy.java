package fruitshop.strategy;

import fruitshop.model.Operation;
import fruitshop.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
