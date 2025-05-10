package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitStorageDao {
    void setQuantity(String fruitName, Integer quantity);

    Integer getQuantity(String fruitName);

    Set<Map.Entry<String, Integer>> getAll();
}
