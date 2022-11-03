package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void addFruitQuantity(FruitTransaction fruitTransaction);

    void subtractFruitQuantity(FruitTransaction fruitTransaction);

    void putFruit(FruitTransaction fruit);
}
