package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Integer getValue(Fruit key);

    Integer putValue(String key, Integer value);

    Set<Map.Entry<Fruit, Integer>> getEntrySet();
}
