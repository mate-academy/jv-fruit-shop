package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {

    void put(String fruit, int amount);

    void remove(String fruit, int amount);

    Map<String, Integer> getDataFromStorage();
}
