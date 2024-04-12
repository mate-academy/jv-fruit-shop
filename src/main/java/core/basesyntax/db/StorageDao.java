package core.basesyntax.db;

import java.util.Map;

public interface StorageDao {
    void add(String fruitName, int value);

    Map<String, Integer> get(String fruitName);

    int getQuantity(String fruitName);

    Map<String, Integer> getAll();

    void update(String fruitName, int value);
}
