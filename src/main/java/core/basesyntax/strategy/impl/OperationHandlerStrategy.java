package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationHandlerStrategy(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public OperationHandler get(FruitTransaction operation) {
        return handlerMap.get(operation.getOperation());
    }
}
