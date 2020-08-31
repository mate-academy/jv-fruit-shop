package core.basesyntax;

import java.util.Map;

public interface FileWriterService {
    void writeFile(Map<String, String> conclusionData, String separator, String filename);
}
