package core.basesyntax.dao;

import core.basesyntax.db.Inventory;
import java.util.Map;

public class InventoryDaoImpl implements InventoryDao {
    @Override
    public Map<String, Integer> getCurrentInventoryState() {
        return Inventory.INVENTORY_MAP;
    }

    public void putToInventory(String fruitName, int amount) {
        Inventory.INVENTORY_MAP.put(fruitName, amount);
    }

    public int getAmountByFruit(String fruitName) {
        return Inventory.INVENTORY_MAP.get(fruitName);
    }

}
