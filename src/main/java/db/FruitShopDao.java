package db;

import java.util.Map;
import model.FruitTransaction;

public interface FruitShopDao {
    void add(FruitTransaction fruitTransaction);

    Map<String, Integer> getAllFruitsAndQuantities();

    void update(FruitTransaction fruitTransaction);
}
