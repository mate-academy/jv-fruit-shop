package core.basesyntax.fruitshop.service;

import java.io.IOException;
import java.util.Map;

public interface WriterService {
    void writeReport(Map<String, Integer> fruitInventory, String filePath) throws IOException;
}
