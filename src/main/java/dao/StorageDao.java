package dao;

import java.util.Map;

public interface StorageDao {
    void update(String fruitName, Integer amount);

    Integer getFruitQuantity(String fruit);

    Map<String, Integer> getAll();
}
