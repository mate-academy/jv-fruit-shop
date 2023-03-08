package core.basesyntax.db;

import java.util.Map;

public class StorageTransactions {
    private static Map<String, Integer> storage;

    public static Map<String, Integer> getStorage() {
        return storage;
    }

    public static void setStorage(Map<String, Integer> storage) {
        StorageTransactions.storage = storage;
    }
}
