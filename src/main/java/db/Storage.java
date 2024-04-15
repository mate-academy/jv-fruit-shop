package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUITS_BALANCE_REPORT = new HashMap<>();

    public static HashMap<String, Integer> getFruitsBalanceReport() {
        return new HashMap<>(FRUITS_BALANCE_REPORT);
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
        FRUITS_BALANCE_REPORT.putAll(fruitTransactions);
    }

    public static void clearStorage() {
        FRUITS_BALANCE_REPORT.clear();
    }
}
