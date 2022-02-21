package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao<K, V> {

    void addStorage(String fruit, int amount);

    int getFruitCount(String nameFruit);

    void removeFromStorage(String fruitName, int amount);

    Map<K, V> getAllFruits();
}
