package core.basesyntax.reportgenerator;

import core.basesyntax.db.Storage;

public interface ReportGenerator {
    String getReport(Storage dataToReport);
}
