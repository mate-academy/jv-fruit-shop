package core.basesyntax.dao.storage;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> getAll();

    int getQuantityByKey(String key);

    void put(String key, int value);

    boolean checkIfExist(String key);

    boolean isEnoughFruits(String fruit, int quantity);
}
