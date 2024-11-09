package core.basesyntax.dao;

public interface FruitDao {
    void supplyFruit(String fruit, int quantity);

    void boughtFruit(String fruit, int quantity);

    void returnFruit(String fruit, int quantity);
}
