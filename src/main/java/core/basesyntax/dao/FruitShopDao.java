package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitShopDao {
    void add(FruitTransaction fruitTransaction);
    FruitTransaction get(FruitTransaction fruitTransaction);
}
