package core.basesyntax.service;

import java.util.Map;

public interface DataWriterService {
    void writeData(Map<String, Integer> fruits, String filePath);
}
