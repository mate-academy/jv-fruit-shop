package core.basesyntax.dao;

import java.util.Map;

public interface CsvOutputFileWriter {
    void createCscWithTitle();
    void saveResultsToCsv(Map<String, Integer> fruits);
}
