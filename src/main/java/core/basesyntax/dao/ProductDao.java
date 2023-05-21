package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface ProductDao {

    void update(FruitTransaction fruitTransaction, int count);

    int getQuantityOf(FruitTransaction fruitTransaction);

    String getAllData();
}
