package core.basesyntax.report;

import core.basesyntax.storage.FruitStorage;

public interface ReportBuilder {
    String buildReport(FruitStorage storage);
}
