package service;

import java.util.List;

public interface FileService {
    List<String> readFromCsvFile(String filePath);

    void writeToCsvFile(String filePath, String reportData);
}
