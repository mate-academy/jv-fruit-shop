package core.basesyntax.service.files;

import java.util.List;

public interface ReportWriter {
    void writeReportToFile(String fileName, List<String> report);
}
