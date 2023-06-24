package core.basesyntax.service;

import java.util.Map;

public interface WriteService {
    void writeToFile(Map<String, Integer> storage, String path);
}
