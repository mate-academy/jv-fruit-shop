package db;

import java.util.Map;

public interface Storage {
    void set(String fruit, Integer quantity);

    void add(String fruit, Integer quantity);

    void remove(String fruit, Integer quantity);

    Map<String, Integer> getAllData();
}
