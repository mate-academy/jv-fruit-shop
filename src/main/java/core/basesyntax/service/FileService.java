package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, String text);
}
