package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruit, Integer quantity);

    Integer get(String fruit);
}
