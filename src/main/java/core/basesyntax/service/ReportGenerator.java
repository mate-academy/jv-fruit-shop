package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface ReportGenerator {
    String generateReport(Storage storage);
}
