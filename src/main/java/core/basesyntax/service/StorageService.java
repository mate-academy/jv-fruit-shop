package core.basesyntax.service;

public interface StorageService {
    void add(String key, Integer value);

    void update(String key, Integer value);

    void remove(String key, Integer value);

    Integer get(String key);
}
