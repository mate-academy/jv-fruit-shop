package core.basesyntax.dao;

public interface FruitStorageDao {
    void add(String fruitName, int quantity);

    void update(String fruitName, int quantity);
}
