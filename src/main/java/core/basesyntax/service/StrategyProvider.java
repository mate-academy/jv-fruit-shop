package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public interface StrategyProvider {
    void setStrategy(FruitTransaction.Operation key, OperationStrategy strategy);

    OperationStrategy getStrategy(FruitTransaction.Operation key);
}
