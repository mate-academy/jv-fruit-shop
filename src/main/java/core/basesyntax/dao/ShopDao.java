package core.basesyntax.dao;

import core.basesyntax.shop.Fruit;

public interface ShopDao {
    boolean add(Fruit fruits, int count);

    int get(Fruit fruit);

}
