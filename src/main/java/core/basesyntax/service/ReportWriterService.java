package core.basesyntax.service;

import java.util.List;

public interface ReportWriterService {
    void saveReport(List<String> report, String toFilePath);
}
