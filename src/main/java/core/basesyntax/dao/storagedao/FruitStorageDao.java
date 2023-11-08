package core.basesyntax.dao.storagedao;

import core.basesyntax.dao.transaction.FruitTransaction;
import java.util.List;

public interface FruitStorageDao {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAllTransaction();
}
