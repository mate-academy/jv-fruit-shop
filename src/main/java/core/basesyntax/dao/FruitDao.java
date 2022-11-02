package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitDao {
    void putFruit(FruitTransaction fruit);

    void putFruit(String fruitName, Integer quantity);
}
