package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {
    static Map<String, Integer> getStorage() {
        return Storage.storage;
    }
}
