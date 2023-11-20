package db;

import java.util.Map;

public interface FruitShopDao {
    void put(String fruit, Integer quantity);

    Map<String, Integer> getAllFruitsAndQuantities();

    Integer getFruitQuantity(String fruit);
}
