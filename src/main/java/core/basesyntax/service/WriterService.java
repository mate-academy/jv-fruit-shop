package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void fileWriter(String fileName, List<String> lines);
}
