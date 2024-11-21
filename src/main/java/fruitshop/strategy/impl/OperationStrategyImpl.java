package fruitshop.strategy.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
