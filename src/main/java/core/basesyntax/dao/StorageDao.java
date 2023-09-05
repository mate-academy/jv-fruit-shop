package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface StorageDao {
    void putFruit(String key, Integer value);

    List<String> getAllFruits();

    Map<String, Integer> getMap();
}
