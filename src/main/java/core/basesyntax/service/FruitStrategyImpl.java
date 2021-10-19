package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public FruitStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void applyToStorage(Map<String, Integer> fruitQuantityMap,
                               String operation,
                               String fruitName,
                               int quantity) {
        OperationHandler operationHandler = operationHandlerMap.get(operation);
        operationHandler.apply(fruitQuantityMap, fruitName, quantity);

    }
}
