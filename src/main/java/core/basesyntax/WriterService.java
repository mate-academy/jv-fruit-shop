package core.basesyntax;

import java.util.Map;

public interface WriterService {
    void writeToFile(String filePath, Map<String, Integer> fruitQuantities);
}
