package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageDao {
    void updateValue(List<FruitTransaction> fruitTransactions);
}
