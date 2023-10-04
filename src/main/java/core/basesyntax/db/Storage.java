package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public interface Storage {
    Map<String, Integer> storage = new HashMap<>();

    void update(FruitTransaction fruitTransaction, int count);

    int calculateAmount(FruitTransaction fruitTransaction);
}
