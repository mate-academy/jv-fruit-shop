package core.basesyntax.fruitshop.service;

import java.util.Map;

public interface WriterService {
    void writeReport(Map<String, Integer> fruitInventory, String filePath);
}
