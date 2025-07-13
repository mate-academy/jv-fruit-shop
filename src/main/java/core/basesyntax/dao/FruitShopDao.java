package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitShopDao {
    void add(String fruit, int amount);

    FruitTransaction get(String fruit);
}
