package core.basesyntax.dao;

public interface FruitStorageDao {
    void add(String fruit, Integer quantity);

    void replace(String fruit, Integer quantity);

    int get(String fruit);
}

