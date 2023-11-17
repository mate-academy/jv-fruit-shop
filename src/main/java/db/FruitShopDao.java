package db;

import model.FruitTransaction;

public interface FruitShopDao {
    void add(FruitTransaction fruitTransaction);

    void update(FruitTransaction fruitTransaction);
}
