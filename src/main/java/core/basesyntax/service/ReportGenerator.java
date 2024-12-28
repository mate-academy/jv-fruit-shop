package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportGenerator {
    String getReport(List<FruitTransaction> fruitTransactionList);
}
