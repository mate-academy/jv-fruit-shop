package core.basesyntax.files;

import java.util.Map;

public interface FileWriter {
    void writeReport(Map<String, Integer> data, String reportPath);
}
