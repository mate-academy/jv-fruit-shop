package core.basesyntax.data.dao;

import java.util.Map;

public interface FileWriter {
    void writeFile(String fileName, Map<String, Integer> inventory);
}
