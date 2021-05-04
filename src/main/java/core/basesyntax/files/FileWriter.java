package core.basesyntax.files;

import java.util.Map;

public interface FileWriter {
    void createReport(Map<String, Integer> report, String path);
}
