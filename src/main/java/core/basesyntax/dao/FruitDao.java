package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void update(String key, int value);

    Map<String, Integer> getAll();

    int get(String key);
}
