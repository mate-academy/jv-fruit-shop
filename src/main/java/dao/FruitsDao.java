package dao;

import model.Fruit;

public interface FruitsDao {
    void addProduct(Fruit fruit, Integer count);

    Integer getValue(Fruit fruit);
}
