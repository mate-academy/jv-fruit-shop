package core.basesyntax.dao;

public interface FruitDao {
    void addFruit(String fruit, int amount);

    int get(String fruit);
}
