package core.storage;

import java.util.Map;

public interface Storage {
    void add(String fruit, Integer quantity);

    void remove(String fruit, Integer quantity);

    Map<String, Integer> getAllData();
}
