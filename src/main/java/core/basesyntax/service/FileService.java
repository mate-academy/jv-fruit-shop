package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void write(String path, String content);

    List<String> readDataFromFile(String path);
}
