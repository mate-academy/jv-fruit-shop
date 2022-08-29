package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.strategyimpl.OperationHandler;

public interface OperationStrategy {
    OperationHandler getStrategy(FruitTransaction.Operation operation);
}
