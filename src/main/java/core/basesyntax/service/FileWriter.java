package core.basesyntax.service;

import java.util.Map;

public interface FileWriter {
    void writeDataInFile(Map<String, Long> report, String fileName);
}
