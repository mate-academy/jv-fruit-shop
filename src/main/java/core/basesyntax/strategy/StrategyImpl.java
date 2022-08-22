package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.FruitOperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, FruitOperationHandler> handlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation, FruitOperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public FruitOperationHandler get(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
