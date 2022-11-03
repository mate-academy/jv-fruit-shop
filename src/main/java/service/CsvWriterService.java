package service;

import java.util.List;

public interface CsvWriterService {
    boolean writeToFile(String filePath, List<String> report);
}
