package core.basesyntax.dao;

public interface StorageDao {
    int getStoredQuantity(String fruitName);

    void addFruit(String fruitName, Integer quantity);

    void removeFruitLot(String fruitName);
}
