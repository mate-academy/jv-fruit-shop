package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface ReportGenerator {
    String getReport(List<FruitTransaction> fruitTransactionList);
}
