package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private final Map<Operation, OperationHandler> handlerOperationMap;

    public FruitOperationStrategyImpl(Map<Operation, OperationHandler> handlerOperationMap) {
        this.handlerOperationMap = handlerOperationMap;
    }

    @Override
    public int countFruits(FruitTransaction fruitTransaction) {
        return handlerOperationMap.get(fruitTransaction.getOperation())
                .count(fruitTransaction);
    }
}
