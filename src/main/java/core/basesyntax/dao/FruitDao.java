package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    void subtract(String fruit, int quantity);

    void addition(String fruit, int quantity);

    Map<String, Integer> getAll();

}
