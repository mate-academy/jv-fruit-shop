package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void writeReport(String path, Map<String, Integer> report);
}
