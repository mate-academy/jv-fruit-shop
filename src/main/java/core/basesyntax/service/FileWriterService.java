package core.basesyntax.service;

import core.basesyntax.FruitBatch;
import java.util.Map;

public interface FileWriterService {
    void writeToFile(String filePath, Map<FruitBatch, Integer> fruits);

    Map<String, Integer> formatData(Map<FruitBatch, Integer> fruits);
}
