package core.basesyntax.dao;

public interface StorageDao {
    void add(String fruit, int quantity);

    int getQuantity(String fruit);
}
