package strategy;

import java.util.Map;
import model.Fruit;
import strategy.operationhandlers.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Fruit.Operation,OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
