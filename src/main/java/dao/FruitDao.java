package dao;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public interface FruitDao {
    boolean containsKey(String key);

    void put(String string, Integer count);

    Set<Map.Entry<String, Integer>> getEntries();

    void merge(String key, Integer value, BiFunction<? super Integer,
            ? super Integer, ? extends Integer> remappingFunction);
}
