package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void addToStorage(String fruit, int quantity);

    void removeFromStorage(String fruit, int quantity);

    void updateStorage(String fruit, int quantity);

    Map<String, Integer> getMapHandler();
}
