package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFile(String filePath);
    void writeToFile(String report, String filePath);
}
