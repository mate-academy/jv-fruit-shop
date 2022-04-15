package core.basesyntax.dao;

import java.util.Map;

public interface FruitShopService {
    void add(String fruit, int quantity);

    Integer getAmount(String fruit);

    Map<String, Integer> getStorage();
}
