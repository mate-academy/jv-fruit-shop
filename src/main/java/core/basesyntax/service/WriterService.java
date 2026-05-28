package core.basesyntax.service;

import java.util.Map;

public interface WriterService {
    void writeToFile(Map<String, Integer> data, String filePath);
}
