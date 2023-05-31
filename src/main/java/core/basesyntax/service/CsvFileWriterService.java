package core.basesyntax.service;

public interface CsvFileWriterService {
    void writeToFile(String filePath, ReportGenerationService reportGenerationService);
}
