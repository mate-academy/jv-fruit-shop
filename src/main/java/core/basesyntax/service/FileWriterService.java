package core.basesyntax.service;

import java.util.Map;

public interface FileWriterService {
    void writeToFile(String filePath, Map<String, Integer> formattedData);
}
