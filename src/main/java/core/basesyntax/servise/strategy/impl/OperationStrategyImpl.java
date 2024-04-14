package core.basesyntax.servise.strategy.impl;

import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;
import core.basesyntax.servise.strategy.OperationStrategy;

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
