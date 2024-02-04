package core.basesyntax.service;

import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import java.util.List;

public interface ReportGenerator {
    List<FruitResultingRow> generateReport(List<FruitTransactionRow> transactions);
}
