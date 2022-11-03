package core.basesyntax.dao;

import java.util.Map;
import java.util.function.BiFunction;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    void merge(String fruit, Integer quantity,
               BiFunction<? super Integer,
                       ? super Integer, ? extends Integer> remappingFunction);

    Integer get(String fruit);

    Map<String, Integer> getAll();
}
