package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void writeToFile(String filePath, String data);

    List<String> readDataFromFile(String fileName);
}
