package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {
    void add(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    Map<String, Integer> getAll();
}
