package core.fruitshop.strategy.implementation;

import core.fruitshop.OperationType;
import core.fruitshop.strategy.interfaces.OperationHandler;
import core.fruitshop.strategy.interfaces.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getStrategy(OperationType type) {
        return handlersMap.get(type);
    }
}
