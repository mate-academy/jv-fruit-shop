package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> shopStorage = new HashMap<>();

    public static Map<String, Integer> getShopStorage() {
        return shopStorage;
    }

    public static void updateStorage(String fruit, int amount) {
        if (shopStorage.containsKey(fruit)) {
            if (shopStorage.get(fruit) + amount < 0) {
                throw new RuntimeException("Balance of " + fruit + " is negative");
            }
            shopStorage.put(fruit, shopStorage.get(fruit) + amount);
        } else {
            if (amount < 0) {
                throw new RuntimeException("Trying to add  " + fruit + " with negative amount");
            }
            shopStorage.put(fruit, amount);
        }
    }
}
