package core.basesyntax.service;

public interface ReportWriterToFile {

    void createReport(String filePath, ReportCreator reportCreator);
}
