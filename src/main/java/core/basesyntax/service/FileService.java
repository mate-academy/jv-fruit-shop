package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> read(String fileName);

    void writeToFile(String content, String fileName);
}
