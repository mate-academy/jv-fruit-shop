package core.basesyntax.dao;

import java.util.Map;

public interface FruitShopDao {
    void add(String nameFruit, int quantity);

    Map<String, Integer> getAll();
}
