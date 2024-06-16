package core.basesyntax.reportservices;

import java.util.List;

public interface ReportToFile {
    void writeReportToFile(List<String> report, String fileName);
}
