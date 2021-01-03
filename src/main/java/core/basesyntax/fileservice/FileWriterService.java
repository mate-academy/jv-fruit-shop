package core.basesyntax.fileservice;

import java.util.List;
import java.util.Map;

public interface FileWriterService {
    void writeToFile(Map<String, Integer> balance, String filePath);
}