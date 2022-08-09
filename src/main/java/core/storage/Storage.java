package core.storage;

import java.util.Map;

public interface Storage {
    void add(String fruit, Integer quantity);

    void removeFromStorage(String fruit, Integer quantity);

    Map<String, Integer> getAllData();
}
