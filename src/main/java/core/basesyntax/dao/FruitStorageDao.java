package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitStorageDao {
    void add(String name, int quantity);

    int getValue(String name);

    boolean containsKey(String name);

    void update(String name, int quantity);

    Set<Map.Entry<String, Integer>> entrySet();
}
