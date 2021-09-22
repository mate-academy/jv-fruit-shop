package core.basesyntax.service;

import java.util.Map;

public interface FileWriterCsv {
    void writeReportInFile(String pathToFile, Map<String, Integer> report);
}
