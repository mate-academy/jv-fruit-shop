package core.basesyntax.dao;

import java.util.Map;
import java.util.function.BiFunction;

public interface FruitDao {
    void add(String fruitName, int quantity, BiFunction<Integer, Integer, Integer> operation);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
