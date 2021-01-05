package core.basesyntax.service.work.with.file;

import java.util.List;

public interface Report {
    String writeReport(List<String> list);

    void createReport(List<String> list);

    void writeReportToFile(String report, String toFileName);
}
