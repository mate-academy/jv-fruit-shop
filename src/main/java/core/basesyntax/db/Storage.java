package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    // Dodana metoda clear dla łatwiejszego testowania, choć opcjonalna
    public static void clear() {
        fruitStorage.clear();
    }
}
