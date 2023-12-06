package core.basesyntax.db;

import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public interface Storage {
    void put(String key, Integer value);

    void merge(String key, Integer value, BinaryOperator<Integer> mergeFunction);

    Set<Map.Entry<String,Integer>> entrySet();
}
