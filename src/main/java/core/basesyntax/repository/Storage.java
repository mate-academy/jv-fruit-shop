package core.basesyntax.repository;

import java.util.Map;

public interface Storage {
    void add(String fruitName, Integer value);

    Integer getQuantity(String fruitName);

    Map<String, Integer> getAll();
}
