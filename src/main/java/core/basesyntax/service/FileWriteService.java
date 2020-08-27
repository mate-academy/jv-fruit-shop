package core.basesyntax.service;

import java.util.Map;

public interface FileWriteService {
    boolean writeFile(Map<String, Integer> fruits, String outputFile);
}
