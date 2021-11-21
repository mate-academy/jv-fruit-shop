package core.basesyntax.service;

public interface ReportService {
    String getReportText();

    void writeReport(String report, String fileName);
}
