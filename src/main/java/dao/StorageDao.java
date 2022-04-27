package dao;

import model.Fruit;

public interface StorageDao {
    void update(Fruit fruit, int quantity);
}
