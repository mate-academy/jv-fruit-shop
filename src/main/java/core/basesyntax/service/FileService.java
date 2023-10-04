package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readLines(String filePath);

    void writeDataToFile(String filePath, String data);
}
