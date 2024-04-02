package core.basesyntax.service;

import java.util.Map;

public interface WriteToFile {
    void writeReport(String path, Map<String, Integer> report);
}
