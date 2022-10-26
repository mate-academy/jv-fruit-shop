package core.basesyntax.dao;

import java.util.HashMap;

public interface FruitStorageDao {
    void addFruit(String key, Integer value);

    void modifyValue(String key, Integer value);

    Integer get(String key);

    HashMap<String, Integer> getStorage();
}
