package core.basesyntax.dao;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    void retrieve(String fruit, Integer quantity);
}
