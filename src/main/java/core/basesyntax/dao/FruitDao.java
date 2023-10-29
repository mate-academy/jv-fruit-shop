package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void add(String fruit, Integer amount);

    Integer getQuantity(String fruit);

    Set<Map.Entry<String, Integer>> getAll();
}
