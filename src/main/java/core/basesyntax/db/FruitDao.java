package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {
    Integer putFruits(String key, Integer value);

    Map<String, Integer> getFruitDB();
}
