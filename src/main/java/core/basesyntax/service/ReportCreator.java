package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportCreator {
    String createReport(List<FruitTransaction> fruitTransactions);
}
