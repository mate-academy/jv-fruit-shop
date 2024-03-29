package core.basesyntax.service;

import java.util.Map;

public interface FileWriterService {
    public void writeToFile(Map<String, Integer> report, String filePath);
}
