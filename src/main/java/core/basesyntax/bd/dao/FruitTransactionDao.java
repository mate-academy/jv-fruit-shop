package core.basesyntax.bd.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitStorage);

    FruitTransaction get(String fruitName);
}
