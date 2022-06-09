package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> get();

    boolean isEmpty();
}
