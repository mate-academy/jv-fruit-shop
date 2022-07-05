package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeToFile(String filePath, List<String> lines);
}
