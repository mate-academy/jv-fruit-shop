package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionDao {
    void add(FruitTransaction transaction);
    void putFruitIntoMap(String fruitName, Integer count);
}
