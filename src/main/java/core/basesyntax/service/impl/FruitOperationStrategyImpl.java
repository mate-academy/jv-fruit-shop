package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationStrategy;
import core.basesyntax.strategy.FruitsOperationHandler;
import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<FruitTransaction.Operation, FruitsOperationHandler> amountHandlerMap;

    public FruitOperationStrategyImpl(Map<FruitTransaction.Operation,
            FruitsOperationHandler> amountHandlerMap) {
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public FruitsOperationHandler get(FruitTransaction.Operation operation) {
        return amountHandlerMap.get(operation);
    }
}
