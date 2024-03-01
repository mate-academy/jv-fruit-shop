package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategyService {
    void calculateTransaction(FruitTransaction fruitTransaction);
}
