package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void replaceValue(String name, Integer quantity);

    Integer getQuantity(String name);

    Map<String, Integer> getMap();
}
