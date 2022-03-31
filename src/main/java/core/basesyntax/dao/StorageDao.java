package core.basesyntax.dao;

public interface StorageDao {
    void add(String fruit, int quantity);

    void update(String fruit, int quantity);
}
