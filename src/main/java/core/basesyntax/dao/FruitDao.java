package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruit, int quantity);

    int get(String fruit);
}
