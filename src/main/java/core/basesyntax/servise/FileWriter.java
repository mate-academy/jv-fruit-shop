package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FileWriter {
    void createReport(Map<Fruit, Integer> map, String filePath);
}
