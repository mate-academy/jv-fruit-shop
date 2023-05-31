package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface FruitDao {
    void add(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
