package core.basesyntax.dao;

public interface FruitOperationDao {
    int get(String fruit);

    void put(String fruit, Integer quantity);
}
