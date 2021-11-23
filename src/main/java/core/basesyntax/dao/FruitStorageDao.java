package core.basesyntax.dao;

public interface FruitStorageDao {
    void addNewFruitToStorage(String name, int quantity);

    void update(String name, int quantity);
}
