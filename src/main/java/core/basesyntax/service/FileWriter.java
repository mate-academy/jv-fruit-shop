package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void writeToFile(Map<String, Integer> report, String filePath);
}
