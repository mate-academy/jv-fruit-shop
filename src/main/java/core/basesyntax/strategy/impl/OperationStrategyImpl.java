package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationHandler getHandlerByOperation(FruitTransaction.Operation operation) {
        return null;
    }
}

