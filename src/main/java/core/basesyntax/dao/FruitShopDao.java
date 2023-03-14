package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitShopDao {
    void add(Fruit fruit);
    Fruit get(Fruit.TYPE type);
}
