package core.basesyntax.service.impl;

import core.basesyntax.service.Inventory;
import java.util.HashMap;
import java.util.Map;

public class InventoryImpl implements Inventory {
    private Map<String, Integer> inventory = new HashMap<>();

    @Override
    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
