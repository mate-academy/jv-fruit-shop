package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> STORAGE = new HashMap<>();

    public static HashMap<String, Integer> getFruitsBalanceReport() {
        return new HashMap<>(STORAGE);
    }

    public static void saveToFruitsBalanceReport(Map<String, Integer> fruitTransactions) {
        for (Map.Entry<String, Integer> entry : fruitTransactions.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("The balance of "
                        + entry.getKey()
                        + " is negative: "
                        + entry.getValue());
            }
        }
        STORAGE.putAll(fruitTransactions);
    }

    public static void clearStorage() {
        STORAGE.clear();
    }
}
