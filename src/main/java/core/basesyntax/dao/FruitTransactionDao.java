package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);

    void update(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAllListDb();
}
