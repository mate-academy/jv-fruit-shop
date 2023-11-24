package model;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private Map<String, Integer> fruitInventory;

    public FruitStorage() {
        fruitInventory = new HashMap<>();
    }

    public FruitStorage(Map<String, Integer> fruitInventory) {
        this.fruitInventory = fruitInventory;
    }

    public Map<String, Integer> getFruitInventory() {
        return fruitInventory;
    }
}
