package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface CsvFileWriter {
    void writeToFile(String filePath, List<Fruit> fruits);
}
