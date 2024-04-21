package core.basesyntax.service;

import java.nio.file.Path;

public interface CsvReportService {
    void writeReport(Path path);
}
