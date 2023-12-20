package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageDao {
    void add(FruitTransaction fruit);

    List<FruitTransaction> getAll();

    FruitTransaction getBalance(FruitTransaction fruitTransaction);
}
