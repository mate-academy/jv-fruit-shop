package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handlerfruits.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationHandlerStrategyImpl(Map<FruitTransaction
            .Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return handlerMap.get(type);
    }
}
