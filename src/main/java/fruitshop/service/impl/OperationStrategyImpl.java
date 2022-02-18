package fruitshop.service.impl;

import fruitshop.model.Operation;
import fruitshop.service.OperationStrategy;
import fruitshop.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public static final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    @Override
    public void chooseStrategy(Operation operation, String fruit, Integer quantity) {
        for (Map.Entry<Operation, OperationHandler> mapEntry : operationHandlerMap.entrySet()) {
            if (mapEntry.getKey().equals(operation)) {
                mapEntry.getValue().updateAmountOfFruit(fruit, quantity);
            }
        }
    }
}
