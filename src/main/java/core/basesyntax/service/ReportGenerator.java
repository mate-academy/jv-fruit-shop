package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportGenerator {
    void generateReport(List<FruitTransaction> fruitTransactions);
}
