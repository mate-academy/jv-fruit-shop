package core.basesyntax.dao;

import java.util.Map;

public interface ShopDao {
    Integer get(String fruit);

    Map<String, Integer> getAll();

    void update(String fruit, int newAmount);
}
