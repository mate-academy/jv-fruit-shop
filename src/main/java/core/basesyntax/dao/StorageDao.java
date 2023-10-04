package core.basesyntax.dao;

public interface StorageDao {
    void set(String fruit, int quantity);

    Integer get(String fruitName);
}
