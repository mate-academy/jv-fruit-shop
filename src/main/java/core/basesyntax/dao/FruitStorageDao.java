package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {

    void addAll(Map<String, Integer> map);

    Map<String, Integer> getAll();
}
