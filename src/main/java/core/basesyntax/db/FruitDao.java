package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {
    Integer updateFruitQuantity(String key, Integer value);

    Map<String, Integer> getAllFruits();
}
