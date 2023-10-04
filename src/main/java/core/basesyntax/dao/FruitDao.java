package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String key, Integer quantity);

    Map<String, Integer> getStorage();
}
