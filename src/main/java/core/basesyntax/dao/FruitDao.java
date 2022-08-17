package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void setQuantityForFruit(String fruit, int quantity);

    int getQuantityForFruit(String fruit);

    Map<String, Integer> getStorageData();
}
