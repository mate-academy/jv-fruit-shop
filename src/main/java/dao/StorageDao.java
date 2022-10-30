package dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void setQuantity(String fruitName, Integer quantity);

    Integer getQuantity(String fruitName);

    Set<Map.Entry<String, Integer>> getAll();
}
