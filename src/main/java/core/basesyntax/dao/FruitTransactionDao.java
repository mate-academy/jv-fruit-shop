package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    void addAll(List<FruitTransaction> fruitTransactions);
}
