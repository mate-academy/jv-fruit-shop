package core.basesyntax.service;

import java.util.Map;

public interface ShopDao {
    Map.Entry<String, Integer> get(String fruit);

    Map<String, Integer> getAll();

    void update(String fruit, int newAmount);
}
