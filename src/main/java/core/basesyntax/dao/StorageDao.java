package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> getStorage();

    int getAmountByObjectType(String objectName);

    void putToStorage(String objectName, int amount);
}
