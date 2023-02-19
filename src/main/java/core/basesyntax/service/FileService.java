package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> read(String toPath);

    void write(String toPath, String report);
}
