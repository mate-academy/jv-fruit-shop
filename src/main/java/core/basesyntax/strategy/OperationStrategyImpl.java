package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<Operation, FruitOperationHandler> fruitOperationHandlerMap;

    public OperationStrategyImpl(
            Map<Operation, FruitOperationHandler> fruitOperationHandlerMap) {
        this.fruitOperationHandlerMap = fruitOperationHandlerMap;
    }

    @Override
    public FruitOperationHandler getHandler(Operation operation) {
        return fruitOperationHandlerMap.get(operation);
    }
}
