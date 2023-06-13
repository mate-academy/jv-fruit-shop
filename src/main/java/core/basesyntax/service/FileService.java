package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String path);

    void writeToFile(String path, String reportString);
}
