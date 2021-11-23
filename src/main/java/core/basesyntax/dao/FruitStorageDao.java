package core.basesyntax.dao;

public interface FruitStorageDao {
    void add(String name, int quantity);

    boolean get(String name);

    void update(String name, int quantity);
}
