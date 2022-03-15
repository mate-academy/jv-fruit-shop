package strategy;

import java.util.Map;
import model.Fruit;
import operation.Operation;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Fruit.Operation, Operation> operationOperationHandlerMap;

    public FruitStrategyImpl(Map<Fruit.Operation, Operation> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public Operation get(Fruit.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}

