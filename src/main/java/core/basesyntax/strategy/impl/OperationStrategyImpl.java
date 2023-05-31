package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> handlersMap
    ) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        return handlersMap.get(fruitTransaction.getOperation());
    }
}
