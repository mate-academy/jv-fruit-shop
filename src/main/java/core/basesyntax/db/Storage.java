package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitBalance = new HashMap<>();

    public static Map<String, Integer> getFruitBalance() {
        return fruitBalance;
    }

    public static void setFruitBalance(String fruit, int quantity) {
        Storage.fruitBalance.put(fruit, quantity);
    }
}
