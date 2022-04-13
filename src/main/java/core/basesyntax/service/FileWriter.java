package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeLines(String filePath, List<String> records);
}
