package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void writeReport(Map<String, Integer> reportMap, String fileName);
}
