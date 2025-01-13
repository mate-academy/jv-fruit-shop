package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface ReportGenerator {
    String getReport(Storage storage);
}
