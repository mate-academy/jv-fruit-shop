package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitTransactionDao {
    void addTransaction(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAllTransactions();

    void fetchTransactionSummaryData(Map<String,Integer> summaryData);
}
