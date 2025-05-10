package service;

import java.util.List;

public interface ReaderService {
    List<String> readFromCsvFile(String filePath);
}
