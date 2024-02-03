package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionRow;
import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    Map<String, Integer> calcFruitsLeftAfterTransactions(List<FruitTransactionRow> transactions);
}
