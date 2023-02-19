package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void updateStorage(String fruit, int quantity);

    Map<String, Integer> getFruitsFromStorage();
}
