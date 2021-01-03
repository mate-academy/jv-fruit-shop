package core.basesyntax;

import java.util.Map;

public interface CsvFileWriter {
    void createStockFile(Map<String, Integer> stockBalance);
}
