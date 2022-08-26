package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    void subtract(FruitTransaction fruitTransaction);

    void addition(FruitTransaction fruitTransaction);

    Map<String, Integer> getAll();

}
