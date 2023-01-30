package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String inputFileName);

    void writeToFile(String fileName, String report);
}
