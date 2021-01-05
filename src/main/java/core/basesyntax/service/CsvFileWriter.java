package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface CsvFileWriter {
    void writeToFile(String filePath, Map<Fruit, Integer> fruits);
}
