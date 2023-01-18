package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void writeToFile(String text, String path);

    List<String> readFromFile(String path);
}
