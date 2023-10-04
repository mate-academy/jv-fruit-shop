package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeDataToFile(String filePath, List<String> lines);
}
