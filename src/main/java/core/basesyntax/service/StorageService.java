package core.basesyntax.service;

import java.util.HashMap;

public interface StorageService {
    void save(String name, Integer quantity);

    Integer get(String key);

    HashMap<String, Integer> getAll();

    void update(String name, Integer value);

}
