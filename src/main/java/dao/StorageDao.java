package dao;

import model.Fruit;

public interface StorageDao {
    void addNewFruit(Fruit fruit);

    void changeQuantityOfFruit(Fruit fruit);
}
