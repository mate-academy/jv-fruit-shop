package core.basesyntax.db.dao;

import java.util.Map;

public interface StorageDao {
    void set(String fruitName, int fruitQuantity);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
