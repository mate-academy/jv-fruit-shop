package core.basesyntax.db;

import java.util.HashMap;

public class FruitInventory {
    private static HashMap<String, Integer> inventory = new HashMap<>();

    public static HashMap<String, Integer> getInventory() {
        return inventory;
    }
}
