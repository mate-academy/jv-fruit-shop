package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void writeFile(String filePath, String report);

    List<String> readFile(String filePath);
}
