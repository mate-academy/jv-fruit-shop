package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fromFilePath);

    void writeDataToFile(String report);
}
