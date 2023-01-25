package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportService {
    String createReport(List<FruitTransaction> fruitTransactions);
}
