package core.basesyntax.dao;

import java.util.Map;

public interface FruitShopDao {
    void add(String fruit, int quantity);

    Integer getAmount(String fruit);

    Map<String, Integer> getStorage();
}
