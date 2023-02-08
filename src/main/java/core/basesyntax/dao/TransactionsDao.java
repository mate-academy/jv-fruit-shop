package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsDao {
    void addTransaction(FruitTransaction fruitTransaction);

    List<FruitTransaction> getTransactions();
}
