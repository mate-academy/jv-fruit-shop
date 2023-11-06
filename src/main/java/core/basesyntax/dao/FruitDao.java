package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void put(String fruitName, int quantity);

    int get(String fruitName);

    Set<Map.Entry<String, Integer>> getInventoryEntries();
}
