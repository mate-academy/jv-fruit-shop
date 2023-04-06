package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface Transaction {
    void transaction(FruitTransaction fruitTransaction, StrategyController controller);
}
