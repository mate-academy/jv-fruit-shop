package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationStrategy {
    int countFruits(FruitTransaction fruitTransactions);
}
