package core.basesyntax.service;

import java.util.List;

public interface ReportWriterService {
    void createReportFile(List<String> stringsToWrite, String toFileName);
}
