package core.basesyntax.dao;

public interface FruitDao {
    void add(String name, int amount);

    void set(String name, int amount);

    void remove(String name, int amount);
}
