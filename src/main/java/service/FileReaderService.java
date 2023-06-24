package service;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String inputFilePath);
}
