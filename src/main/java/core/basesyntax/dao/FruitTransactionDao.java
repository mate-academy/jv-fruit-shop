package core.basesyntax.dao;

import core.basesyntax.db.FruitTransaction;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);
    FruitTransaction get();
}
