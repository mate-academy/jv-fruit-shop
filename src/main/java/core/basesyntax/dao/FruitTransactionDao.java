package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {

    void add(List<FruitTransaction> dailyTransactions);

    List<FruitTransaction> getAllTransaction();
}
