package core.basesyntax.db;

import core.basesyntax.service.FruitTransactionParserCsv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageImpl implements Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static Integer getFruitAmount(String fruit) {
        if (storage.isEmpty() || !storage.containsKey(fruit)) {
            return 0;
        }
        return storage.get(fruit);
    }

    public static void putFruitToStorage(String fruit, Integer amount) {
        storage.put(fruit, amount);
    }

    public static List<String> getStorage() {
        return storage.entrySet()
                .stream()
                .map(s -> s.getKey().toString().toLowerCase()
                        + FruitTransactionParserCsv.SEPARATE_SYMBOL_FOR_CSV
                        + s.getValue())
                .collect(Collectors.toList());
    }
}
