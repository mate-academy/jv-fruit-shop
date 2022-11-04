package com.basesyntax.dao;

import com.basesyntax.model.Fruit;

public interface FruitDao {
    void put(Fruit fruit, Integer amount);

    Integer getAmountCurrentFruitInShop(Fruit fruit);

    void update(Fruit fruit, Integer newValue);

    Fruit remove();
}
