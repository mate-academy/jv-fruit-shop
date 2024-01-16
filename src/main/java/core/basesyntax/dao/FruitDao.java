package core.basesyntax.dao;

public interface FruitDao {
    void addFruit(String fruit, int quantity);

    void subtractFruit(String fruit, int quantity);
}
