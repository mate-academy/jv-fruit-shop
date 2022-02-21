package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> read(String incomeFile);

    void write(String file, String report);
}
