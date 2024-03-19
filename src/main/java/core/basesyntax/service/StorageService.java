package core.basesyntax.service;

import java.util.Map;

public interface StorageService {
    void save(String name, Integer quantity);

    Integer get(String key);

    Map<String, Integer> getAll();

    void update(String name, Integer value);
}
