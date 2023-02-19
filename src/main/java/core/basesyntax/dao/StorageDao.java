package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import java.util.Map;

public interface StorageDao {
    void addToStorage(Transaction transaction);

    void removeFromStorage(Transaction transaction);

    void updateStorage(Transaction transaction);

    Map<String, Integer> getMapHandler();
}
