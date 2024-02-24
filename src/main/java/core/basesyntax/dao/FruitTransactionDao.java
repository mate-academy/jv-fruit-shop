package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    List<FruitTransaction> getAllTransactions(String fileName);
}
