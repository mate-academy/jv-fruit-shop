package core.basesyntax.dao;

public interface FruitsDao {

    Storage getStorage();

    void addFruitToStorage(String key, Integer value);

    Integer getFruitFromStorage(String fruitName);
}
