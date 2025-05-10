package dao;

import java.util.Map;

public interface StorageDao {
    void addFruitToStorage(String fruit, int amount);

    int getAmount(String fruit);

    Map<String, Integer> getAll();
}
