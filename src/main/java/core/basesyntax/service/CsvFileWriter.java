package core.basesyntax.service;

import java.util.Map;

public interface CsvFileWriter {
    boolean writeToFile(Map<String, Integer> stockBalance, String filePath);
}
