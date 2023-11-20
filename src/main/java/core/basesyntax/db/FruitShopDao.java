package core.basesyntax.db;

import java.util.Map;

public interface FruitShopDao {
    void add(String fruit, Integer quantity);

    Map<String, Integer> getAllFruitsAndQuantities();

    Integer getFruitQuantity(String fruit);
}
