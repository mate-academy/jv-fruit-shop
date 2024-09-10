package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    Map<String, Integer> getStorage();

    int getQuantity(String key);

    void addEntry(String key, Integer value);

    void removeEntry(String key);
}
