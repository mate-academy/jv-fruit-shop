package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionStorageDao {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAllAsList();
}
