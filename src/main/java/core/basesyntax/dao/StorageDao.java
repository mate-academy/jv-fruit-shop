package core.basesyntax.dao;

public interface StorageDao {
    int getData(String fruit);

    void putInData(String fruit, int quantity);

    void updateData(String fruit, int newQuantity);
}
