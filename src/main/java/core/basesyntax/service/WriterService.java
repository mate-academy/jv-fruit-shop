package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void writeToFile(String fileName, List<String> data);
}
