package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitShopDao {
    void add(FruitTransaction fruit);
    FruitTransaction get(FruitTransaction.TYPE type);
}
