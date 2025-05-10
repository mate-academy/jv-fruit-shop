package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    Integer get(FruitTransaction fruitTransaction);

    Map<String,Integer> getAll();
}
