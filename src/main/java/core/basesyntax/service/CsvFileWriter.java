package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface CsvFileWriter {
    void reportFile(Map<Fruit, Integer> fruitReport, String filePath);
}
