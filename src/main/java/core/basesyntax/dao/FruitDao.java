package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String fruit, int quantity);

    int get(String fruit);

    Map<String, Integer> getAll();
}
