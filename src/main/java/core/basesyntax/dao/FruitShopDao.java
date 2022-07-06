package core.basesyntax.dao;

import java.util.List;

public interface FruitShopDao {
    void put(String fruit, Integer quantity);

    Integer get(String fruit);

    List<String> getAll();
}
