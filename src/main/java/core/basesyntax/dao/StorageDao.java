package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageDao {
    List<FruitTransaction> readTransactions(String filePath);
}
