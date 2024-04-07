package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> read(String filePath);

    void write(String filePath);
}
