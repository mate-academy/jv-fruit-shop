package core.basesyntax.service;

import core.basesyntax.service.impl.ReadFromCsvFileImpl;

public interface ReportCreator {
    String createReport(ReadFromCsvFileImpl file);
}
