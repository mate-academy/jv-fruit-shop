package core.basesyntax.dao;

public interface StorageDao {
    void set(String key, int quantity);

    void add(String key, int quantity);

    void subtract(String key, int quantity);
}
