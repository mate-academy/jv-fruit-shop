package core.basesyntax.dao;

import java.util.Map;

public interface FruitQuantityDao {
    void add(String fruit, int quantity);

    Map<String, Integer> getAll();

    int get(String fruit);
}
