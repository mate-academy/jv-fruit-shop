package core.basesyntax.service;

import java.util.Map;

public interface StorageService {
    void add(String name, Integer quantity);

    Integer get(String key);

    Map<String, Integer> getAll();
}
