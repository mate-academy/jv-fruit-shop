package dao;

import model.Fruit;

public interface StorageDao {
    void add(Fruit fruit, int quantity);

    void update(Fruit fruit, int quantity);

    Integer get(Fruit fruit);
}
