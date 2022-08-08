package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void clear();

    void add(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    Map<String, Integer> getData();
}
