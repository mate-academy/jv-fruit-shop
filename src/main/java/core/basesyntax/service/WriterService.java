package core.basesyntax.service;

import java.util.Set;

public interface WriterService {
    void writeToFile(String filePath, Set<String> lines);
}
