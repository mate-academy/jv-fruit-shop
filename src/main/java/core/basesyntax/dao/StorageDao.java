package core.basesyntax.dao;

public interface StorageDao {
    int getQuantity(String fruit);

    void putInStorage(String fruit, int quantity);

}
