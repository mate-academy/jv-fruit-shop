package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    void put(String fruit, Integer amount);

    void remove(String fruit, Integer amount);

    Map<String, Integer> getDataFromStorage();
}
