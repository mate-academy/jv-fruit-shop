package storage;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class Storage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static Map<String, Integer> getFruitsStorage() {
        return fruitsStorage;
    }

    public static int getFruitQuantity(FruitTransaction transaction) {
        return fruitsStorage.entrySet().stream()
                .filter(i -> i.getKey().equals(transaction.getName()))
                .mapToInt(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can`t find this fruit"
                        + transaction.getName()));
    }
}
