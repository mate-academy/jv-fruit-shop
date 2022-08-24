package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportBuilder {
    List<String> getReport(List<FruitTransaction> transactions);
}
