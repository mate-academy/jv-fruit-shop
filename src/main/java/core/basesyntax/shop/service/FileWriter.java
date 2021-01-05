package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import java.util.Map;

public interface FileWriter {
    void createReportFile(Map<Fruit, Integer> fruitReport, String filePath);
}
