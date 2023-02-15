package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    void add(String fruitName, int quantity);

    Integer get(String fruitName);

    Map<String,Integer> getAll();
}
