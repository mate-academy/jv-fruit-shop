package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitOperationStrategy {
    void countFruits(List<FruitTransaction> fruitTransactions);
}
