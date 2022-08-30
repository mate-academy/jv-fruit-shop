package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    void subtract(String fruit, int quantity);

    void addition(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getEntries();

}
