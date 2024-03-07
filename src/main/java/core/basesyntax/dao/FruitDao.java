package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Integer add(String fruitName, int amount);

    Set<Map.Entry<String, Integer>> getFruits();
}
