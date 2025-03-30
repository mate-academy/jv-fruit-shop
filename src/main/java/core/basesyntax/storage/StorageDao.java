package core.basesyntax.storage;

public interface StorageDao {
    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);
}
