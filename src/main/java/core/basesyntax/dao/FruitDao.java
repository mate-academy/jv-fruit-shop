package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruit, int quantity);

    Integer get(String fruit);
}
