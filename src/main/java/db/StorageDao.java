package db;

import java.util.Map;

public interface StorageDao {
    void add(Map<String, Integer> fruitsToAdd);

    void subtract(Map<String, Integer> fruitsToSubtract);

    int get(String fruitName);
}
