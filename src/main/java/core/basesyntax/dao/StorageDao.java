package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void add(String fruitName, Integer amount);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
