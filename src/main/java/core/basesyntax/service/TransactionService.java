package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface TransactionService {
    void executeTransaction(FruitTransaction fruitTransaction, FruitStorage fruitStorage);
}
