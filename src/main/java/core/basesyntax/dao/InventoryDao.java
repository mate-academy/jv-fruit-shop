package core.basesyntax.dao;

import java.util.Map;

public interface InventoryDao {
    Map<String, Integer> getCurrentInventoryState();

    int getAmountByFruit(String fruitName);

    void putToInventory(String fruitName, int amount);
}
