package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyStorage {
    OperationHandler getStrategy(FruitTransaction fruitTransaction);
}
