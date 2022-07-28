package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> getFromFile(String filePath);

    void writeToTheFile(String filePath, List<String> lines);
}
