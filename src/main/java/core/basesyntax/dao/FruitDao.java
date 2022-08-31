package core.basesyntax.dao;

public interface FruitDao {
    void addToStorage(String fruit, int amount);

    int getFruitAmount(String fruit);
}
