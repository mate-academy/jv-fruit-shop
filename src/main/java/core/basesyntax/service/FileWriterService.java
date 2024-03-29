package core.basesyntax.service;

import java.util.Map;

public interface FileWriterService {
    void writeToFile(Map<String, Integer> report, String filePath);
}
