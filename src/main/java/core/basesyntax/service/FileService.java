package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void writeToFile(String filename);

    List<String> readFile(String filename);
}
