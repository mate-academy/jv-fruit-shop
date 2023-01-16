package core.basesyntax.dao;

public interface StorageDao {
    void add(String name, Integer quantity);

    void update(String name, Integer quantity);

    Integer get(String name);
}
