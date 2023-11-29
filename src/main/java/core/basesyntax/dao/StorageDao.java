package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    boolean contains(String fruitName);

    void add(String fruitName);

    Integer get(String fruitName);

    Map<String, Integer> getMap();

    void update(String fruitName, Integer newAmount);
}
