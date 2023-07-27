package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ReportCreator<T> {
    String createReport(Map<String, Integer> report, List<FruitTransaction> fruitTransactions);
}
