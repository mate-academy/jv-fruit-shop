package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUITS_BALANCE_REPORT = new HashMap<>();

    public static HashMap<String, Integer> getFruitsBalanceReport() {
        return new HashMap<>(FRUITS_BALANCE_REPORT);
    }

    public static void saveToFruitsBalanceReport(Map<String, Integer> fruitTransactions) {
        FRUITS_BALANCE_REPORT.putAll(fruitTransactions);
    }
}
