package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FileWriterService {
    void writeToFile(Map<Fruit, Integer> balance, String filePath);
}
