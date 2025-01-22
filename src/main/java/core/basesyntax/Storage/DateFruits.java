package core.basesyntax.Storage;

import java.util.HashMap;
import java.util.Map;

public class DateFruits {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static void save(String name, Integer amount) {
        fruitsStorage.put(name, amount);
    }

    public static Integer get(String name) {
        return fruitsStorage.get(name) == null ? 0 : fruitsStorage.get(name);
    }

    public static Map<String, Integer> getAll() {
        return Map.copyOf(fruitsStorage);
    }
}
