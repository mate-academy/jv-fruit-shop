package dao;

import model.FruitModel;

public interface StorageDao {
    int get(String key);

    boolean put(FruitModel fruitModel);

    boolean replace(String name, int amount);

    boolean containsKey(String key);
}
