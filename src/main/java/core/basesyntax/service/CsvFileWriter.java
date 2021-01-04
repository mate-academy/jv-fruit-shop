package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface CsvFileWriter {
    void writeData(Map<Fruit, Integer> fruits, String toFileName);
}
