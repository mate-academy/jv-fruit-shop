package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface ReportGenerator {
    String getReport();

    String convertToCsv(Storage storage);
}
