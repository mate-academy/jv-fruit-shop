package service.impl;

import java.util.HashMap;
import model.FruitTransaction;
import service.InventoryDao;

public class InventoryDaoImpl implements InventoryDao {
    public HashMap<String,Integer> getInventoryMap(Inventory inventory) {
        return inventory.inventoryMap;
    }
    @Override
    public boolean addToStorage(FruitTransaction operation, Inventory inventory) {
            if (getInventoryMap())
            getInventoryMap(inventory).put(operation.getFruitName(), operation.getQuantity());
            return true;
    }
}
