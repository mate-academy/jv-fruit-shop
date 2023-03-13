package core.basesyntax.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
public interface ValueOfFruit<T> {
    T valueOf(String fruit, int amount);

    default List<T> valueOf(Map<String, Integer> fruits) {
        return fruits.entrySet().stream()
                .map(e -> valueOf(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
