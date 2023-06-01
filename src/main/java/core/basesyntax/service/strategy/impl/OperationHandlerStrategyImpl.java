package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationHandlerStrategy;

import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationHandlerStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> handlersMap
    ) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getByOperation(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}
