package dao;

import java.util.Map;

public interface StorageDao {
    void set(String fruitName, Integer quantity);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
