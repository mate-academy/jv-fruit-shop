package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionService {
    void executeTransaction(FruitTransaction fruitTransaction);
}
