package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Storage {
    private static final Map<String, Integer> FRUITS = new HashMap<>();

    private Storage() {
    }

    public static Map<String, Integer> getSnapshot() {
        return Collections.unmodifiableMap(new HashMap<>(FRUITS));
    }

    public static int getQuantity(String fruit) {
        return FRUITS.getOrDefault(fruit, 0);
    }

    public static void putQuantity(String fruit, int quantity) {
        FRUITS.put(fruit, quantity);
    }

    // Використовувати тільки всередині реалізацій сервісів (package-private доступ можна організувати інакше)
    public static Map<String, Integer> internalMapForService() {
        return FRUITS;
    }
}
