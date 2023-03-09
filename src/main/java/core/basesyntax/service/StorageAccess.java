package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface StorageAccess {
    List<String> readData(String fileName);

    void writeData(Map<String, Integer> data, String fileName);
}
