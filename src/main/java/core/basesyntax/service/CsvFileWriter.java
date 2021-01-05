package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface CsvFileWriter {
    void writeReport(String filePath, Map<Fruit, Integer> storage);
}
