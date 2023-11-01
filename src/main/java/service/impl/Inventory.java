package service.impl;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> inventoryMap;

    public Inventory() {
        this.inventoryMap = new HashMap<>();
    }
    public HashMap<String, Integer> getInventoryMap() {
        return this.inventoryMap;
    }

}
