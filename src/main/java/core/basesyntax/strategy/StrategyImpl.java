package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
