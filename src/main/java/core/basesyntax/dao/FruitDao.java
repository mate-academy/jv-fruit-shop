package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruit);

    Integer get(String fruit);

    void update(String fruit, int quantity);
}
