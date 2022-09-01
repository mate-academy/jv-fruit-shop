package core.basesyntax.dao;

public interface FruitDao {
    void add(String fruit, int amount);

    int getFruitAmount(String fruit);
}
