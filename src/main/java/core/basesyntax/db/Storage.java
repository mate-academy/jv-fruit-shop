package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    void add(String fruit, Integer quantity);

    Integer getQuantityByFruit(String fruit);

    Map<String, Integer> getAll();
}
