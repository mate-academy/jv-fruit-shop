package dao;

import java.util.List;

public interface FruitStorageDao {
    void add(String fruitName, int fruitQuantity);

    int get(String fruitName);

    List<String> getAllFruitsNames();
}
