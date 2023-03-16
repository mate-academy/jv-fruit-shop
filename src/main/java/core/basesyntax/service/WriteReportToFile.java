package core.basesyntax.service;

import java.util.Map;

public interface WriteReportToFile {
    void writeData(Map<String, Integer> fruits, String filePath);
}
