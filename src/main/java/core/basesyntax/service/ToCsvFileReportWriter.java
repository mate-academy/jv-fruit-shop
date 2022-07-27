package core.basesyntax.service;

public interface ToCsvFileReportWriter {
    void writeReport(String filePath, String report, String header);
}
