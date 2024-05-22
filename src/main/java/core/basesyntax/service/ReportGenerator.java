package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface ReportGenerator {
    public String getReport(Storage storage);
}
