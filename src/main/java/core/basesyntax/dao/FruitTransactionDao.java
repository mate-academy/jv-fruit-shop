package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionDao {
    FruitTransaction getFromStorage(FruitTransaction fruitTransaction);

    void addToStorage(FruitTransaction fruitTransaction);
}
