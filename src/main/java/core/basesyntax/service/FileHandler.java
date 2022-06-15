package core.basesyntax.service;

import java.util.List;

public interface FileHandler {
    void writeFile(String fileName, String data);

    List<String> readFile(String fileName);

    void clearFile(String fileName);
}
