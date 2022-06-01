package core.basesyntax.services;

import java.util.Map;

public interface WriteToFileService {
    void putDbToFile(Map<String, Integer> dayResult, String fileName);
}
