package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import java.util.Map;

public interface StorageDao {
    void addToStorage(String fruit, int quantity);

    void removeFromStorage(String fruit, int quantity);

    void updateStorage(String fruit, int quantity);

    Map<String, Integer> getMapHandler();
}
