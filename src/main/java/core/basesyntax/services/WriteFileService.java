package core.basesyntax.services;

import java.util.Map;

public interface WriteFileService {
    void writeToFile(Map<String, Integer> resultStore, String fileName);
}
