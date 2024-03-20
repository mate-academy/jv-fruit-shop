package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeTo(String filePath, List<String> rows);
}
