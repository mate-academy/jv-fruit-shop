package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface ReportDao {
    Map<String, Integer> getReport();

    void updateReport(FruitTransaction fruitTransaction);

    int getBalanceFruitTransaction(FruitTransaction fruitTransaction);
}
