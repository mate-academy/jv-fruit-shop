package dao;

import java.util.Map;

public interface StorageDao {
    void setQuantity(String fruitName, Integer quantity);

    Integer getQuantity(String fruitName);

    Map<String, Integer> getAll();
}
