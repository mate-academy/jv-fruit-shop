package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ReportService {
    String createFinalReport(Map<String, Integer> map);

    void applyTransactionsToStorage(List<FruitTransaction> fruitTransactionList);
}
