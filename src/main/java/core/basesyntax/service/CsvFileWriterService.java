package core.basesyntax.service;

public interface CsvFileWriterService {
    void writeToFile(String toFileName, StringBuilder report);
}
