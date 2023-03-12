package core.basesyntax.db.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void add(String fruitType, Integer quantity);
    Integer get(String fruitType);

}
