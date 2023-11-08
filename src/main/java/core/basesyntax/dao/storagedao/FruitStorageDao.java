package core.basesyntax.dao.storagedao;

import core.basesyntax.dao.transaction.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface FruitStorageDao {
    void add(FruitTransaction fruitTransaction);
    List<FruitTransaction> getAllTransaction();
}
