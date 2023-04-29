package core.basesyntax.service;

import java.util.Map;

public interface WriterService {
    void writeToFile(String path, Map<String, Integer> data);
}
