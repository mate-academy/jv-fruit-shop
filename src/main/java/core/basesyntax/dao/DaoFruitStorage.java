package core.basesyntax.dao;

import java.util.Map;

public interface DaoFruitStorage {
    Map<String, Integer> getFromFruitStorage();

    Integer getQuantityFromFruitStorage(String fruitType);

    void addToFruitStorage(String fruitType, int quantity);
}
