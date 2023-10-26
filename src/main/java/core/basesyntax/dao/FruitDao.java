package core.basesyntax.dao;

public interface FruitDao {
    void add(String name, int quantity);

    void set(String name, int quantity);

    void remove(String name, int quantity);
}
