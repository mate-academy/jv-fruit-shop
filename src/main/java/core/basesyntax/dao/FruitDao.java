package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getStorage();

    Integer get(String key);

    void add(String name, Integer quantity);
}
