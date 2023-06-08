package core.basesyntax;

import java.util.List;

public interface ReportWriter {
    void writeReport(List<String> report, String filePath);
}
