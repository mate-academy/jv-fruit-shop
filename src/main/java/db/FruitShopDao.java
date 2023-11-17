package db;

import model.FruitTransaction;

import java.util.Map;

public interface FruitShopDao {
    void add(FruitTransaction fruitTransaction);

    Map<String, Integer> getAllFruitsAndQuantities();

    void update(FruitTransaction fruitTransaction);
}
