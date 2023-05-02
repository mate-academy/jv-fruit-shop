package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void writeToFile(String path, List<String> lines);
}
