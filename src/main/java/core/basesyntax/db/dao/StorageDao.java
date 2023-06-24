package core.basesyntax.db.dao;

import java.util.Map;

public interface StorageDao {
    void set(String fruitName, Integer fruitAmount);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
