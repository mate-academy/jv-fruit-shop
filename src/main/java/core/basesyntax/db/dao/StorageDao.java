package core.basesyntax.db.dao;

public interface StorageDao {
    void add(String fruitType, Integer quantity);

    Integer get(String fruitType);
}
