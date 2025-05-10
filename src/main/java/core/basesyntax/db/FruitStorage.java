package core.basesyntax.db;

import java.util.Map;

public interface FruitStorage {
    void add(String fruitName, Integer quantity);

    Integer getQuantity(String fruitName);

    Map<String, Integer> getAll();
}
