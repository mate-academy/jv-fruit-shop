package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitStorageDao {
    void addToStorage(List<FruitTransaction> transactionList);
}
