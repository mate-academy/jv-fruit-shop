package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface ReportDao {
    Map<String, Integer> getReport();

    void updateReportBalance(FruitTransaction fruitTransaction);

    void updateReport(FruitTransaction fruitTransaction, int balanceAfter);

    int getBalanceFruitTransaction(FruitTransaction fruitTransaction);
}
