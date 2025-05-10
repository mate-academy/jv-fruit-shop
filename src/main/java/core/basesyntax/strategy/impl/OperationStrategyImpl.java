package core.basesyntax.strategy.impl;

import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final MapOfHandlersForStrategyImpl mapOfStrategy;

    public OperationStrategyImpl(MapOfHandlersForStrategyImpl mapOfStrategy) {
        this.mapOfStrategy = mapOfStrategy;
    }

    @Override
    public OperationService getOperationHandler(FruitTransaction fruitTransaction) {
        return mapOfStrategy.getMap().get(fruitTransaction.getOperation());
    }
}
