package core.basesyntax.dao;

import java.util.Map;

public interface Dao {
    void clear();

    void add(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    Map<String, Integer> getData();
}
