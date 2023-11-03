package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> getStorage();

    int getQuantityByObjectType(String object);

    void putToStorage(String object, int quantity);
}
