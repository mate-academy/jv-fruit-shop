package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionsStrategy {
    FruitTransaction.Operation get(String dataFromFile);
}
