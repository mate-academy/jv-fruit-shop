package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface StoreCsvDao {
    void add(FruitTransaction fruitTransaction);
    List<FruitTransaction> getTransactionList(String transactionType);

    List<FruitTransaction> getAll();
    void saveReportToFile(Map<String,Integer> report);
}
