package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void saveFruit(String fruit, int quantity);

    Integer getQuantity(String fruit);

    Map<String, Integer> getAll();
}
