package service;

import java.util.List;

public interface CsvReaderService {
    List<String> readFromFile(String filePath);
}
