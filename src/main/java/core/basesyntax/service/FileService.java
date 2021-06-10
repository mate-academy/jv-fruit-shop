package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> readFile(String fileName);

    void writeFile(String filename, String report);
}
