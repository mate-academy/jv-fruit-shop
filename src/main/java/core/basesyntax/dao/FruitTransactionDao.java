package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);
    FruitTransaction get();
}
