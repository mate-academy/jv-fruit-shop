package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void writeToFile(String fileName);

    List<String> readFile(String fileName);
}
