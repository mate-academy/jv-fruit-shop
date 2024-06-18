package core.basesyntax.service;

import java.util.List;

public interface ReportToFile {
    void writeReportToFile(List<String> report, String fileName);
}
