package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitTransactionDao {
    void add(String name, Integer quantity);

    void update(String name, Integer quantity);

    int getByName(String name);

    Set<Map.Entry<String, Integer>> getFull();
}
