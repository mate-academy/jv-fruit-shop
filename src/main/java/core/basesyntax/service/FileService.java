package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fromFileName);

    void writeToFile(String toWriteFile, String toWriteData);
}
