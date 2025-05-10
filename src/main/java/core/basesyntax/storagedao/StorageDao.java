package core.basesyntax.storagedao;

public interface StorageDao {
    void add(String fruit, int quantity);

    void subtract(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    void clear();
}
