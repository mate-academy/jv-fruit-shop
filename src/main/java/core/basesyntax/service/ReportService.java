package core.basesyntax.service;

import core.basesyntax.db.Storage;

import java.util.List;

public interface ReportService {
    public List<String> generateReport(Storage storage);
}
