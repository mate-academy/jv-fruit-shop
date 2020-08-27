package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> stockBalance = new HashMap<>();

    public static Map<String, Integer> getStockBalance() {
        return stockBalance;
    }

    public static void addFruit(String fruit, Integer quantity) {
        stockBalance.put(fruit, quantity);
    }
}
