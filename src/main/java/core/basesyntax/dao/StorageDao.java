package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> save(String fruit, int quantity);

    Map<String, Integer> getAll();

    int getQuantity(String key);
}
