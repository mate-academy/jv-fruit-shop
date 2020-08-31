package core.basesyntax;

import java.util.Map;

public interface FileWriterService {
    void writeToFile(Map<String, String> conclusionData, String filename);
}
