package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ReportGenerator {
    String getReport(List<FruitTransaction> list);
}
