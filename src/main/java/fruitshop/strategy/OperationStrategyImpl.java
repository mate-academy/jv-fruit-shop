package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (!handlerMap.containsKey(operation)) {
            throw new RuntimeException("Unknown operation: " + operation);
        }
        return handlerMap.get(operation);
    }
}
