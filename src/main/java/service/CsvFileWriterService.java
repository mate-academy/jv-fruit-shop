package service;

import java.util.List;

public interface CsvFileWriterService {
    void writeToFile(List<String> report, String filePath);
}
