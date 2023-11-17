package core.basesyntax.db.dao;

public interface StorageDao {
    void putItem(String name, int quantity);

    void addItem(String name, int quantity);

    int getBalance(String name);
}
