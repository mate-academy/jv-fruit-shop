package strategy;

import model.Fruit;
import operation.OperationHandler;

import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Fruit.Operation, OperationHandler> operationOperationHandlerMap;

    public FruitStrategyImpl(Map<Fruit.Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}

