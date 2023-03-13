package core.basesyntax.service;

import java.util.Map;

public interface WriteService {
    void writeFile(Map<String, Integer> storage, String path);
}
