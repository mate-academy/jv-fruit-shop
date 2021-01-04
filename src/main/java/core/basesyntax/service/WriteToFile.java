package core.basesyntax.service;

import java.util.Map;

public interface WriteToFile {
    void write(String fileName, Map<String, Integer> shop);
}
