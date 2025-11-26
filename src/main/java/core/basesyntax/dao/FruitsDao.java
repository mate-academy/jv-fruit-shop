package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitsDao {
    void add(FruitTransaction fruits);

    Integer get(String fruitsName);

    Map<String, Integer> getAll();

    void set(String fruitsName, Integer quantity);
}
