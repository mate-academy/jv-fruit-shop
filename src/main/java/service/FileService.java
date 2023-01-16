package service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String filePath);

    void writeToFile(String filesToWrite, String outFilePath);
}
