package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface FruitFileWriter {
    void createReportFile(Map<Fruit, Integer> base, String filePath);
}
